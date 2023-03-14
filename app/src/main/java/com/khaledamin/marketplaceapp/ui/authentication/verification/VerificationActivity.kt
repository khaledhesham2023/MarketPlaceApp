package com.khaledamin.marketplaceapp.ui.authentication.verification

import android.content.Intent
import android.os.Bundle
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityVerificationBinding
import com.khaledamin.marketplaceapp.ui.authentication.signup.SignupActivity
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel

class VerificationActivity :
    BaseActivityWithViewModel<ActivityVerificationBinding, VerificationViewModel>() {
    override val layout: Int
        get() = R.layout.activity_verification
    override val viewModelClass: Class<VerificationViewModel>
        get() = VerificationViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(viewDataBinding.toolbar)

    }

    override fun setupObservers() {
//        TODO("Not yet implemented")
    }

    override fun setupListeners() {
        viewDataBinding.backArrow.setOnClickListener {
            startActivity(Intent(this@VerificationActivity, SignupActivity::class.java))
            finish()
        }
    }
}