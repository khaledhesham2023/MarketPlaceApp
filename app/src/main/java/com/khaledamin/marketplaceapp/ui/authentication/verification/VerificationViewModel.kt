package com.khaledamin.marketplaceapp.ui.authentication.verification

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khaledamin.marketplaceapp.model.requests.SendOTPRequest
import com.khaledamin.marketplaceapp.model.requests.VerifyRequest
import com.khaledamin.marketplaceapp.model.responses.SendOTPResponse
import com.khaledamin.marketplaceapp.model.responses.VerifyResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState
import kotlinx.coroutines.launch

class VerificationViewModel(application: Application) : BaseViewModel(application) {

    var sendOTPLiveData = MutableLiveData<ViewState<SendOTPResponse>>()

    var verifyCodeLiveData = MutableLiveData<ViewState<VerifyResponse>>()

    var verifyCustomerLiveData = MutableLiveData<ViewState<VerifyResponse>>()


    fun sendOTP(request: SendOTPRequest) = viewModelScope.launch {
        apiRequestManager.requestApi(repo.sendOTP(request), sendOTPLiveData)
    }

    fun verifyCode(request: VerifyRequest) = viewModelScope.launch {
        apiRequestManager.requestApi(repo.verifyCode(request), verifyCodeLiveData)
    }

    fun verifyCustomer(request: VerifyRequest) = viewModelScope.launch {
        apiRequestManager.requestApi(repo.verifyCustomer(request), verifyCustomerLiveData)
    }
}

