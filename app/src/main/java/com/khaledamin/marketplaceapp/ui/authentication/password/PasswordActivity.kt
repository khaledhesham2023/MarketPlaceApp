package com.khaledamin.marketplaceapp.ui.authentication.password

import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityPasswordBinding
import com.khaledamin.marketplaceapp.model.requests.EditPasswordRequest
import com.khaledamin.marketplaceapp.model.requests.ResetPasswordRequest
import com.khaledamin.marketplaceapp.ui.authentication.login.LoginActivity
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel
import com.khaledamin.marketplaceapp.ui.main.MainActivity
import com.khaledamin.marketplaceapp.utils.ViewState
import com.khaledamin.marketplaceapp.utils.removeErrorsWhenEditing

class PasswordActivity : BaseActivityWithViewModel<ActivityPasswordBinding, PasswordViewModel>() {
    override val layout: Int
        get() = R.layout.activity_password

    override fun initializeComponents() {


        if (sharedPrefRepo.isLoggedIn()) {
            viewDataBinding.editPasswordCollection.visibility = View.VISIBLE
            viewDataBinding.resetPasswordCollection.visibility = View.GONE
        } else {
            viewDataBinding.editPasswordCollection.visibility = View.GONE
            viewDataBinding.resetPasswordCollection.visibility = View.VISIBLE
        }

        removeErrorsWhenEditing(viewDataBinding.newPasswordLayout,
            viewDataBinding.customerConfirmNewPasswordLayout,
            viewDataBinding.currentPasswordLayout,
            viewDataBinding.mobileNumberLayout,
            viewDataBinding.passwordLayout,
            viewDataBinding.customerConfirmPasswordLayout)
    }


    override val viewModelClass: Class<PasswordViewModel>
        get() = PasswordViewModel::class.java

    override fun setupObservers() {
        viewModel.resetPasswordLiveData.observe(this, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    Toast.makeText(this,
                        it.data!!.message,
                        Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@PasswordActivity, LoginActivity::class.java))
                    finish()
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Snackbar.make(this,
                        viewDataBinding.root,
                        getString(R.string.error_password_reset),
                        Snackbar.LENGTH_LONG).show()
                    loadingDialog.dismiss()
                }
            }

        })

        viewModel.editPasswordLiveData.observe(this, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    Toast.makeText(this, it.data!!.message, Toast.LENGTH_SHORT).show()
                    val password = viewDataBinding.customerConfirmNewPassword.text.toString().trim()
                    sharedPrefRepo.savePassword(password)
                    finish()
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun setupListeners() {
        viewDataBinding.confirmResetButton.setOnClickListener {
            if (isDataOkForReset()) {
                viewModel.resetPassword(ResetPasswordRequest(viewDataBinding.mobileNumber.text.toString()
                    .trim('0'),
                    viewDataBinding.password.text.toString().trim(),
                    viewDataBinding.customerConfirmPassword.text.toString().trim(),
                    "20"))
            }
        }

        viewDataBinding.confirmEditButton.setOnClickListener {
            if (isDataOkForEdit()) {
                viewModel.editPassword(EditPasswordRequest(viewDataBinding.currentPassword.text.toString(),
                    viewDataBinding.newPassword.text.toString(),
                    viewDataBinding.customerConfirmNewPassword.text.toString()))
            }
        }
    }

    private fun isDataOkForReset(): Boolean {
        var isDataOk = true
        if (TextUtils.isEmpty(viewDataBinding.mobileNumber.text.toString().trim())) {
            viewDataBinding.mobileNumberLayout.error = getString(R.string.error_mobile_phone)
            isDataOk = false
        }
        if (TextUtils.isEmpty(viewDataBinding.password.text.toString().trim())) {
            viewDataBinding.passwordLayout.error = getString(R.string.password_error)
            isDataOk = false
        }
        if (TextUtils.isEmpty(viewDataBinding.customerConfirmPassword.text.toString().trim())) {
            viewDataBinding.customerConfirmPasswordLayout.error =
                getString(R.string.confirm_password_error)
            isDataOk = false
        }
        if (viewDataBinding.mobileNumber.text.toString().length > 11 || viewDataBinding.mobileNumber.text.toString().length < 11) {
            viewDataBinding.mobileNumberLayout.error = getString(R.string.error_mobile_phone_length)
            isDataOk = false
        }
        if (viewDataBinding.password.text.toString()
                .trim() != viewDataBinding.customerConfirmPassword.text.toString().trim()
        ) {
            viewDataBinding.passwordLayout.error = getString(R.string.error_password_mismatch)
            viewDataBinding.customerConfirmPasswordLayout.error =
                getString(R.string.error_password_mismatch)
            isDataOk = false
        }
        return isDataOk
    }

    private fun isDataOkForEdit(): Boolean {
        var isDataOk = true
        if (TextUtils.isEmpty(viewDataBinding.currentPassword.text.toString().trim())) {
            viewDataBinding.currentPasswordLayout.error = getString(R.string.error_current_password)
            isDataOk = false
        }
        if (TextUtils.isEmpty(viewDataBinding.newPassword.text.toString().trim())) {
            viewDataBinding.newPasswordLayout.error = getString(R.string.new_password_error)
            isDataOk = false
        }
        if (TextUtils.isEmpty(viewDataBinding.customerConfirmNewPassword.text.toString().trim())) {
            viewDataBinding.customerConfirmNewPasswordLayout.error =
                getString(R.string.confirm_new_password_error)
            isDataOk = false
        }
        if (viewDataBinding.newPassword.text.toString()
                .trim() != viewDataBinding.customerConfirmNewPassword.text.toString().trim()
        ) {
            viewDataBinding.newPasswordLayout.error = getString(R.string.error_password_mismatch)
            viewDataBinding.customerConfirmNewPasswordLayout.error =
                getString(R.string.error_password_mismatch)
            isDataOk = false
        }
        return isDataOk
    }

}