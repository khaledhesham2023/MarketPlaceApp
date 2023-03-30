package com.khaledamin.marketplaceapp.ui.categoryproducts

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.model.responses.GetCategoryProductsResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class CategoryProductsViewModel(application: Application) : BaseViewModel(application) {

    var categoriesLiveData = MutableLiveData<ViewState<GetCategoriesResponse>>()
    var categoryProductsLiveData = MutableLiveData<ViewState<GetCategoryProductsResponse>>()

    fun getCategories() = apiRequestManager.requestApi(repo.getCategories(), categoriesLiveData)

    fun getCategoryProducts(catalogId:Long,pageSize: Int, currentPage: Int) =
        apiRequestManager.requestApi(repo.getCategoryProducts(catalogId,pageSize, currentPage),
            categoryProductsLiveData)
}