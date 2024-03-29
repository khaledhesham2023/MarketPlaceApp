package com.khaledamin.marketplaceapp.ui.authentication.verification

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityVerificationBinding
import com.khaledamin.marketplaceapp.model.OTP
import com.khaledamin.marketplaceapp.model.requests.SendOTPRequest
import com.khaledamin.marketplaceapp.model.requests.VerifyRequest
import com.khaledamin.marketplaceapp.ui.authentication.login.LoginActivity
import com.khaledamin.marketplaceapp.ui.authentication.password.PasswordActivity
import com.khaledamin.marketplaceapp.ui.authentication.signup.SignupActivity
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel
import com.khaledamin.marketplaceapp.utils.Constants
import com.khaledamin.marketplaceapp.utils.ViewState
import com.khaledamin.marketplaceapp.utils.createNotification
class VerificationActivity :
    BaseActivityWithViewModel<ActivityVerificationBinding, VerificationViewModel>() {
    override val layout: Int
        get() = R.layout.activity_verification
    override val viewModelClass: Class<VerificationViewModel>
        get() = VerificationViewModel::class.java

    private var resendEnabled = false
    private var resendTime = 60
    private var selectedPosition = 0
    private lateinit var numberEntry: String
    private var smsMessage: Long = 0
    private lateinit var otpCode: String

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            TODO("Not yet implemented")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            if (p0!!.isNotEmpty()) {
                when (selectedPosition) {
                    0 -> {
                        selectedPosition = 1
                        showKeyboard(viewDataBinding.secondNumber)
                    }
                    1 -> {
                        selectedPosition = 2
                        showKeyboard(viewDataBinding.thirdNumber)
                    }
                    2 -> {
                        selectedPosition = 3
                        showKeyboard(viewDataBinding.fourthNumber)
                    }
                    else -> {
                        viewDataBinding.verifyButton.isEnabled = true
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.sendOTP(SendOTPRequest("20", numberEntry))

    }
    @RequiresApi(Build.VERSION_CODES.S)
    override fun setupObservers() {
        viewModel.sendOTPLiveData.observe(this, Observer {
            when (it) {
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    createNotification(it.data!!.code.toString(),
                        this.application,
                        VerificationActivity::class.java,
                        getString(R.string.verification_code))
                    otpCode = it.data.code.toString()
                    smsMessage = it.data.entityId!!
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Snackbar.make(this, viewDataBinding.root, it.message, Snackbar.LENGTH_LONG)
                        .show()
                    loadingDialog.dismiss()
                }
            }

        })

        viewModel.verifyCodeLiveData.observe(this, Observer {
            when(it){
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    sharedPrefRepo.setVerified(true)
                    val intent = Intent(this@VerificationActivity,PasswordActivity::class.java)
                    intent.putExtra("OTP",otpCode)
                    intent.putExtra("sms",smsMessage)
                    startActivity(intent)
                    finish()
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Snackbar.make(this,viewDataBinding.root,getString(R.string.verification_code_error),Snackbar.LENGTH_LONG).show()
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun setupListeners() {
        viewDataBinding.backArrow.setOnClickListener {
            finish()
        }
        viewDataBinding.resendCode.setOnClickListener {
            if (resendEnabled) {
                startCountDownTimer()
                viewModel.sendOTP(SendOTPRequest("20", numberEntry))
            }
        }
        viewDataBinding.verifyButton.setOnClickListener {
            val getOTP = viewDataBinding.firstNumber.text.toString() +
                    viewDataBinding.secondNumber.text.toString() +
                    viewDataBinding.thirdNumber.text.toString() +
                    viewDataBinding.fourthNumber.text.toString()
            if (getOTP.length == 4 && getOTP == otpCode) {
                viewModel.verifyCode(VerifyRequest(OTP(numberEntry,otpCode,"20",smsMessage)))
            }
        }
    }

    private fun showKeyboard(editText: EditText) {
        editText.requestFocus()
        val inputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun startCountDownTimer() {
        resendEnabled = false
        viewDataBinding.resendCode.setTextColor(Color.RED)
        object : CountDownTimer(resendTime * 1000L, 1000) {
            override fun onTick(millisInFuture: Long) {
                viewDataBinding.resendCode.text =
                    getString(R.string.resendCodeAfter, millisInFuture / 1000)
            }

            override fun onFinish() {
                viewDataBinding.resendCode.text = getString(R.string.resendCode)
                viewDataBinding.resendCode.setTextColor(Color.BLACK)
                resendEnabled = true
            }
        }.start()
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            when (selectedPosition) {
                3 -> {
                    selectedPosition = 2
                    showKeyboard(viewDataBinding.thirdNumber)
                }
                2 -> {
                    selectedPosition = 1
                    showKeyboard(viewDataBinding.secondNumber)
                }
                1 -> {
                    selectedPosition = 0
                    showKeyboard(viewDataBinding.firstNumber)
                }
            }
            viewDataBinding.verifyButton.isEnabled = false
            return true
        } else {
            return super.onKeyUp(keyCode, event)

        }
    }

    override fun initializeComponents() {
        numberEntry = sharedPrefRepo.getPhoneNumber()!!

        viewDataBinding.firstNumber.addTextChangedListener(textWatcher)
        viewDataBinding.secondNumber.addTextChangedListener(textWatcher)
        viewDataBinding.thirdNumber.addTextChangedListener(textWatcher)
        viewDataBinding.fourthNumber.addTextChangedListener(textWatcher)
        viewDataBinding.customerPhone.text = getString(R.string.zero,numberEntry)
        showKeyboard(viewDataBinding.firstNumber)
        startCountDownTimer()
    }
}