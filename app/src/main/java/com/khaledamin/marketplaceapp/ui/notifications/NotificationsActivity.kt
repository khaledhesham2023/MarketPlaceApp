package com.khaledamin.marketplaceapp.ui.notifications

import android.content.Intent
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityNotificationsBinding
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel
import com.khaledamin.marketplaceapp.ui.main.MainActivity

class NotificationsActivity :
    BaseActivityWithViewModel<ActivityNotificationsBinding, NotificationsViewModel>() {
    override val layout: Int
        get() = R.layout.activity_notifications
    override val viewModelClass: Class<NotificationsViewModel>
        get() = NotificationsViewModel::class.java

    override fun setupObservers() {
//        TODO("Not yet implemented")
    }

    override fun setupListeners() {
        viewDataBinding.backIcon.setOnClickListener {
            startActivity(Intent(this@NotificationsActivity,MainActivity::class.java))
        }
    }

}