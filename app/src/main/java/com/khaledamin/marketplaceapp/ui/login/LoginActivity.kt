package com.khaledamin.marketplaceapp.ui.login

import android.util.Log
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityLoginBinding
import com.khaledamin.marketplaceapp.ui.base.BaseActivity
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel

class LoginActivity : BaseActivityWithViewModel<ActivityLoginBinding,LoginViewModel>() {
    override val layout: Int
        get() = R.layout.activity_login
    override val viewModelClass: Class<LoginViewModel>
        get() = LoginViewModel::class.java

}