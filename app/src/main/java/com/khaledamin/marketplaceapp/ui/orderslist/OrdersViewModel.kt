package com.khaledamin.marketplaceapp.ui.orderslist

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.model.responses.GetOrdersResponse
import com.khaledamin.marketplaceapp.model.responses.Order
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class OrdersViewModel(application: Application) : BaseViewModel(application) {

    var currentOrdersLiveData = MutableLiveData<ViewState<GetOrdersResponse>>()
    var previousOrdersLiveData = MutableLiveData<ViewState<GetOrdersResponse>>()

    fun getCurrentOrders(pageSize: Int?, currentSize: Int?) =
        apiRequestManager.requestApi(repo.getCurrentOrders(pageSize!!, currentSize!!),
            currentOrdersLiveData)

    fun getPreviousOrders(pageSize: Int?, currentSize: Int?) =
        apiRequestManager.requestApi(repo.getPreviousOrders(pageSize, currentSize),
            previousOrdersLiveData)
}