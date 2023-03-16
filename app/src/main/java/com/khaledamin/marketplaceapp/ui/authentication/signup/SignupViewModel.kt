package com.khaledamin.marketplaceapp.ui.authentication.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khaledamin.marketplaceapp.datasource.remote.Repo.Repo
import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.model.responses.SignupResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ApiRequestManager
import com.khaledamin.marketplaceapp.utils.ViewState
import kotlinx.coroutines.launch

class SignupViewModel(application: Application):BaseViewModel(application) {

    var signupLiveData = MutableLiveData<ViewState<SignupResponse>>()

    fun signup(request: SignupRequest) = viewModelScope.launch {
        apiRequestManager.requestApi(repo.signup(request),signupLiveData)
    }

}