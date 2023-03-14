package com.khaledamin.marketplaceapp.ui.authentication.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.datasource.remote.Repo.Repo
import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.model.responses.SignupResponse
import com.khaledamin.marketplaceapp.utils.ApiRequestManager
import com.khaledamin.marketplaceapp.utils.ViewState

class SignupViewModel(application: Application):AndroidViewModel(application) {

    var _signupLiveData = MutableLiveData<ViewState<SignupResponse>>()

    private val apiRequestManager = ApiRequestManager(application.applicationContext)

    private val repo = Repo()

    fun signup(request: SignupRequest) = apiRequestManager.requestApi(repo.signup(request),_signupLiveData)

}