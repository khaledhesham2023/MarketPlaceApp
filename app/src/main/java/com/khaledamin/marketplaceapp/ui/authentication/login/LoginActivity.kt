package com.khaledamin.marketplaceapp.ui.authentication.login

import android.content.Intent
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityLoginBinding
import com.khaledamin.marketplaceapp.ui.authentication.password.PasswordActivity
import com.khaledamin.marketplaceapp.ui.authentication.signup.SignupActivity
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel
import com.khaledamin.marketplaceapp.ui.main.MainActivity
import com.khaledamin.marketplaceapp.utils.ViewState
import com.khaledamin.marketplaceapp.utils.removeErrorsWhenEditing

class LoginActivity : BaseActivityWithViewModel<ActivityLoginBinding, LoginViewModel>() {
    override val layout: Int
        get() = R.layout.activity_login
    override val viewModelClass: Class<LoginViewModel>
        get() = LoginViewModel::class.java

    override fun setupObservers() {
        viewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    sharedPrefRepo.saveUser(it.data)
                    sharedPrefRepo.setLoggedIn(true)
                    sharedPrefRepo.setBearerToken(it.data!!.extensionAttributes.token)
                    val password = viewDataBinding.password.text.toString().trim()
                    sharedPrefRepo.savePassword(password)
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Snackbar.make(this,
                        viewDataBinding.root,
                        it.message,
                        Snackbar.LENGTH_LONG).show()
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun setupListeners() {
        viewDataBinding.login.setOnClickListener {
            if (isDataOk()) {
                loadingDialog.show()
                viewModel.login(
                    "test",
                    viewDataBinding.mobileNumber.text.toString().trim('0'),
                    viewDataBinding.password.text.toString()
                )
            }
        }
        viewDataBinding.createNew.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
        }
        viewDataBinding.forgetYourPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, PasswordActivity::class.java))
        }
    }

    private fun isDataOk(): Boolean {
        var isDataOk = true
        if (TextUtils.isEmpty(viewDataBinding.mobileNumber.text.toString())) {
            isDataOk = false
            viewDataBinding.mobileNumberLayout.error = getString(R.string.error_mobile_phone)
        }
        if (viewDataBinding.mobileNumber.text.toString().length > 11 || viewDataBinding.mobileNumber.text.toString().length < 11) {
            isDataOk = false
            viewDataBinding.mobileNumberLayout.error = getString(R.string.error_mobile_phone)
        }
        if (TextUtils.isEmpty(viewDataBinding.password.text.toString())) {
            isDataOk = false
            viewDataBinding.passwordLayout.error = getString(R.string.error_password)
        }
        return isDataOk
    }

    override fun initializeComponents() {
        removeErrorsWhenEditing(viewDataBinding.mobileNumberLayout, viewDataBinding.passwordLayout)

    }
}