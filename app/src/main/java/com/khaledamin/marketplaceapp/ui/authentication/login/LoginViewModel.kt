package com.khaledamin.marketplaceapp.ui.authentication.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.datasource.remote.Repo.Repo
import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.model.responses.SignupResponse
import com.khaledamin.marketplaceapp.model.responses.User
import com.khaledamin.marketplaceapp.utils.ApiRequestManager
import com.khaledamin.marketplaceapp.utils.ViewState


class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = Repo()

    private val apiRequestManager = ApiRequestManager(application.applicationContext)

    var _loginLiveData = MutableLiveData<ViewState<User>>()

    val loginLiveData: LiveData<ViewState<User>>
        get() = _loginLiveData

    fun login(header:String,username:String,password:String) = apiRequestManager.requestApi(repo.login(header, username, password),_loginLiveData)


}