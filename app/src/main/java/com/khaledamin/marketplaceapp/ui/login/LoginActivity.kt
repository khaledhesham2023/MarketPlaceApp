package com.khaledamin.marketplaceapp.ui.login

import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityLoginBinding
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel
import com.khaledamin.marketplaceapp.ui.main.MainActivity

class LoginActivity : BaseActivityWithViewModel<ActivityLoginBinding, LoginViewModel>() {
    override val layout: Int
        get() = R.layout.activity_login
    override val viewModelClass: Class<LoginViewModel>
        get() = LoginViewModel::class.java



    override fun setupObservers() {
        viewModel.loginLiveData.observe(this, Observer {
            loadingDialog.dismiss()
            sharedPrefRepo.saveUser(it)
            sharedPrefRepo.setLoggedIn(true)
            sharedPrefRepo.setBearerToken(it.extensionAttributes.token)
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        })
    }

    override fun setupListeners() {
        viewDataBinding.login.setOnClickListener {
            if (isDataOk()) {
                loadingDialog.show()
                viewModel.login(
                    "test",
                    viewDataBinding.mobileNumber.text.toString(),
                    viewDataBinding.password.text.toString()
                )
            }
        }


    }

    fun isDataOk(): Boolean {
        var isDataOk = true
        if (TextUtils.isEmpty(viewDataBinding.mobileNumber.text.toString())) {
            isDataOk = false
            viewDataBinding.mobileNumberLayout.error = getString(R.string.error_mobile_phone)
        }
        if (TextUtils.isEmpty(viewDataBinding.password.text.toString())) {
            isDataOk = false
            viewDataBinding.passwordLayout.error = getString(R.string.error_password)
        }
        return isDataOk
    }
}