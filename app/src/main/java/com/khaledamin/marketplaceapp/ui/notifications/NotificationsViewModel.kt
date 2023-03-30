package com.khaledamin.marketplaceapp.ui.notifications

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState
import com.khaledamin.marketplaceapp.model.responses.Notification

class NotificationsViewModel(application: Application) : BaseViewModel(application) {

    var notificationsLiveData = MutableLiveData<ViewState<ArrayList<Notification>>>()

    fun getNotifications() =
        apiRequestManager.requestApi(repo.getNotifications(), notificationsLiveData)
}