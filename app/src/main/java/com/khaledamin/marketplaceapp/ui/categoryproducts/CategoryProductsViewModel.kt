package com.khaledamin.marketplaceapp.ui.categoryproducts

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class CategoryProductsViewModel(application: Application) : BaseViewModel(application) {

    var categoriesLiveData = MutableLiveData<ViewState<GetCategoriesResponse>>()

    fun getCategories() = apiRequestManager.requestApi(repo.getCategories(),categoriesLiveData)
}