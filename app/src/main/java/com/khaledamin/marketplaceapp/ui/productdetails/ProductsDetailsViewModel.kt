package com.khaledamin.marketplaceapp.ui.productdetails

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.model.responses.GetProductDetailsResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class ProductsDetailsViewModel(application: Application):BaseViewModel(application) {

    var productsDetailsLiveData = MutableLiveData<ViewState<GetProductDetailsResponse>>()

    fun getProductDetails(sku:String?) = apiRequestManager.requestApi(repo.getProductDetails(sku),productsDetailsLiveData)
}