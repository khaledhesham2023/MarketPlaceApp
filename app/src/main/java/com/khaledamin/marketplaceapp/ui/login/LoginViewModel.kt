package com.khaledamin.marketplaceapp.ui.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khaledamin.marketplaceapp.datasource.remote.Repo.Repo
import com.khaledamin.marketplaceapp.model.responses.User
import com.khaledamin.marketplaceapp.utils.ApiRequestManager


class LoginViewModel() : ViewModel() {

    val repo = Repo()

    val apiRequestManager = ApiRequestManager()

    private var _loginLiveData = MutableLiveData<User>()

    val loginLiveData: LiveData<User>
        get() = _loginLiveData

    fun login(header:String,username:String,password:String) = apiRequestManager.requestApi(repo.login(header, username, password),_loginLiveData)



}