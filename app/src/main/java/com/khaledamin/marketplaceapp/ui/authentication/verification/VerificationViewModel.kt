package com.khaledamin.marketplaceapp.ui.authentication.verification

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.model.requests.SendOTPRequest
import com.khaledamin.marketplaceapp.model.requests.VerifyRequest
import com.khaledamin.marketplaceapp.model.responses.SendOTPResponse
import com.khaledamin.marketplaceapp.model.responses.VerifyResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState


class VerificationViewModel(application: Application) : BaseViewModel(application) {

    var sendOTPLiveData = MutableLiveData<ViewState<SendOTPResponse>>()

    var verifyCodeLiveData = MutableLiveData<ViewState<VerifyResponse>>()



    fun sendOTP(request: SendOTPRequest) =
        apiRequestManager.requestApi(repo.sendOTP(request), sendOTPLiveData)


    fun verifyCode(request: VerifyRequest) =
        apiRequestManager.requestApi(repo.verifyCode(request), verifyCodeLiveData)


}

