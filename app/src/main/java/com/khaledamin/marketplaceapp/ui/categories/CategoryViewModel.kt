package com.khaledamin.marketplaceapp.ui.categories

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.khaledamin.marketplaceapp.datasource.remote.Repo.SharedPrefRepo
import com.khaledamin.marketplaceapp.model.responses.Catalog
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class CategoryViewModel(application: Application) : BaseViewModel(application) {

//    var categoriesLiveData = MutableLiveData<ViewState<GetCategoriesResponse>>()

//    fun getCategories() {
//        apiRequestManager.requestApi(repo.getCategories(), categoriesLiveData)
//    }

    var catalogsLiveData = MutableLiveData<ViewState<ArrayList<Catalog>>>()

    fun getCatalogs() {
        apiRequestManager.requestApi(repo.getCatalogs(),catalogsLiveData)
    }
}