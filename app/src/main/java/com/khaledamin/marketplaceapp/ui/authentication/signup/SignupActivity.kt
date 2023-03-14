package com.khaledamin.marketplaceapp.ui.authentication.signup

import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivitySignupBinding
import com.khaledamin.marketplaceapp.model.CustomAttribute
import com.khaledamin.marketplaceapp.model.Customer
import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.ui.authentication.login.LoginActivity
import com.khaledamin.marketplaceapp.ui.authentication.verification.VerificationActivity
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class SignupActivity : BaseActivityWithViewModel<ActivitySignupBinding, SignupViewModel>() {
    override val layout: Int
        get() = R.layout.activity_signup
    override val viewModelClass: Class<SignupViewModel>
        get() = SignupViewModel::class.java

    override fun setupObservers() {
        viewModel._signupLiveData.observe(this@SignupActivity, Observer {
            when (it) {
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    Log.i("TAGG", it.data!!.firstname!!)
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Log.i("TAGG", it.message)
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun setupListeners() {
        viewDataBinding.createNewButton.setOnClickListener {
            val number = viewDataBinding.customerPhone.text.toString()
            val numberEntry = number.trim('0')
            val request = SignupRequest(Customer(arrayListOf(
                CustomAttribute("customer_mobile", numberEntry),
                CustomAttribute("registered_software", "android"),
                CustomAttribute("customer_mobile_code", "20"), CustomAttribute("registered_by", ""),
                CustomAttribute("social_id", "")),
                viewDataBinding.customerEmail.text.toString().trim(),
                viewDataBinding.customerFirstname.text.toString().trim(),
                viewDataBinding.customerLastname.text.toString().trim(),
                1),
                viewDataBinding.customerPassword.text.toString(),
                viewDataBinding.customerConfirmPassword.text.toString())
//            viewModel.signup(request)
            startActivity(Intent(this@SignupActivity,VerificationActivity::class.java))
            finish()
        }

        viewDataBinding.loginText.setOnClickListener {
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }
    }
}