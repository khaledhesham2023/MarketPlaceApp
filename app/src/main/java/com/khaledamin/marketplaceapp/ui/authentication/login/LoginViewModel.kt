package com.khaledamin.marketplaceapp.ui.authentication.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khaledamin.marketplaceapp.datasource.remote.Repo.SharedPrefRepo
import com.khaledamin.marketplaceapp.model.responses.User
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState
import kotlinx.coroutines.launch


class LoginViewModel(application: Application) : BaseViewModel(application) {

    var loginLiveData = MutableLiveData<ViewState<User>>()



    fun login(header: String, username: String, password: String) {
            apiRequestManager.requestApi(repo.login(header, username, password), loginLiveData)
    }

}


