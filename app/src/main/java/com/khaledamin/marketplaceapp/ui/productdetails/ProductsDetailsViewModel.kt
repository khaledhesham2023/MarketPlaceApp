package com.khaledamin.marketplaceapp.ui.productdetails

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.model.responses.GetCategoryProductsResponse
import com.khaledamin.marketplaceapp.model.responses.GetProductDetailsResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class ProductsDetailsViewModel(application: Application):BaseViewModel(application) {

    var productsDetailsLiveData = MutableLiveData<ViewState<GetProductDetailsResponse>>()
    var categoryProductsLiveData = MutableLiveData<ViewState<GetCategoryProductsResponse>>()

    fun getProductDetails(sku:String?) = apiRequestManager.requestApi(repo.getProductDetails(sku),productsDetailsLiveData)
    fun getCategoryProducts(catalogId:Long,pageSize: Int, currentPage: Int) =
        apiRequestManager.requestApi(repo.getCategoryProducts(catalogId,pageSize, currentPage),
            categoryProductsLiveData)
}