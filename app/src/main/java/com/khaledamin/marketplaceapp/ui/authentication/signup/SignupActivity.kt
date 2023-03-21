package com.khaledamin.marketplaceapp.ui.authentication.signup

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivitySignupBinding
import com.khaledamin.marketplaceapp.model.CustomAttribute
import com.khaledamin.marketplaceapp.model.Customer
import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.ui.authentication.login.LoginActivity
import com.khaledamin.marketplaceapp.ui.authentication.verification.VerificationActivity
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel
import com.khaledamin.marketplaceapp.utils.Constants
import com.khaledamin.marketplaceapp.utils.ViewState
import com.khaledamin.marketplaceapp.utils.removeErrorsWhenEditing

class SignupActivity : BaseActivityWithViewModel<ActivitySignupBinding, SignupViewModel>() {
    override val layout: Int
        get() = R.layout.activity_signup
    override val viewModelClass: Class<SignupViewModel>
        get() = SignupViewModel::class.java

    private lateinit var number: String
    private lateinit var numberEntry: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        removeErrorsWhenEditing(
            viewDataBinding.customerFirstnameLayout,
            viewDataBinding.customerPhoneLayout,
            viewDataBinding.customerLastnameLayout,
            viewDataBinding.customerEmailLayout,
            viewDataBinding.customerPasswordLayout,
            viewDataBinding.customerConfirmPasswordLayout
        )
    }

    override fun setupObservers() {
        viewModel.signupLiveData.observe(this@SignupActivity, Observer {
            when (it) {
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    val intent = Intent(this@SignupActivity, VerificationActivity::class.java)
//                    intent.putExtra(Constants.PHONE_NUMBER, numberEntry)
                    if (viewDataBinding.customerPhone.text.toString().startsWith("0")){
                    sharedPrefRepo.savePhoneNumber(viewDataBinding.customerPhone.text.toString().trim('0'))
                    } else {
                        sharedPrefRepo.savePhoneNumber(viewDataBinding.customerPhone.text.toString())
                    }
                    startActivity(intent)
                    finish()
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Snackbar.make(this,viewDataBinding.root,it.message,Snackbar.LENGTH_LONG).show()
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun setupListeners() {
        viewDataBinding.createNewButton.setOnClickListener {
            if (isDataOk()) {
                number = viewDataBinding.customerPhone.text.toString()
                numberEntry = number.trim('0')
                val request = SignupRequest(Customer(arrayListOf(
                    CustomAttribute("customer_mobile", numberEntry),
                    CustomAttribute("registered_software", "android"),
                    CustomAttribute("customer_mobile_code", "20"),
                    CustomAttribute("registered_by", ""),
                    CustomAttribute("social_id", "")),
                    viewDataBinding.customerEmail.text.toString().trim(),
                    viewDataBinding.customerFirstname.text.toString().trim(),
                    viewDataBinding.customerLastname.text.toString().trim(),
                    1),
                    viewDataBinding.customerPassword.text.toString(),
                    viewDataBinding.customerConfirmPassword.text.toString())
                viewModel.signup(request)
            }
        }

        viewDataBinding.loginText.setOnClickListener {
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }
    }

    private fun isDataOk(): Boolean {
        var isDataOk = true
        if (TextUtils.isEmpty(viewDataBinding.customerFirstname.text.toString())) {
            isDataOk = false
            viewDataBinding.customerFirstnameLayout.error = getString(R.string.firstname_error)
        }
        if (TextUtils.isEmpty(viewDataBinding.customerLastname.text.toString())) {
            isDataOk = false
            viewDataBinding.customerLastnameLayout.error = getString(R.string.lastname_error)
        }
        if (viewDataBinding.customerEmail.text.toString()
                .isNotEmpty() && (!viewDataBinding.customerEmail.text.toString()
                .contains("@") && !viewDataBinding.customerEmail.text.toString().contains(".com"))
        ) {
            isDataOk = false
            viewDataBinding.customerEmailLayout.error = getString(R.string.email_error)
        }
        if (viewDataBinding.customerPhone.text.toString().length < 11 || viewDataBinding.customerPhone.text.toString().length > 11) {
            isDataOk = false
            viewDataBinding.customerPhoneLayout.error = getString(R.string.error_mobile_phone_length)
        }
        if (TextUtils.isEmpty(viewDataBinding.customerPhone.text.toString())){
            viewDataBinding.customerPhoneLayout.error = getString(R.string.error_mobile_phone)
        }
        if (TextUtils.isEmpty(viewDataBinding.customerPassword.text.toString())) {
            isDataOk = false
            viewDataBinding.customerPasswordLayout.error = getString(R.string.password_error)
        }
        if (TextUtils.isEmpty(viewDataBinding.customerConfirmPassword.text.toString())) {
            isDataOk = false
            viewDataBinding.customerConfirmPasswordLayout.error =
                getString(R.string.confirm_password_error)
        }
        if (viewDataBinding.customerPassword.text.toString() != viewDataBinding.customerConfirmPassword.text.toString()) {
            isDataOk = false
            Snackbar.make(this,
                viewDataBinding.root,
                getString(R.string.error_password_mismatch),
                Snackbar.LENGTH_LONG).show()
        }
        return isDataOk
    }
}