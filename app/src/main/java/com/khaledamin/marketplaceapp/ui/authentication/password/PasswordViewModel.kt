package com.khaledamin.marketplaceapp.ui.authentication.password

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.datasource.remote.Repo.SharedPrefRepo
import com.khaledamin.marketplaceapp.model.requests.EditPasswordRequest
import com.khaledamin.marketplaceapp.model.requests.ResetPasswordRequest
import com.khaledamin.marketplaceapp.model.responses.EditPasswordResponse
import com.khaledamin.marketplaceapp.model.responses.ResetPasswordResponse
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class PasswordViewModel(application: Application):BaseViewModel(application) {

    var resetPasswordLiveData = MutableLiveData<ViewState<ResetPasswordResponse>>()
    var editPasswordLiveData = MutableLiveData<ViewState<EditPasswordResponse>>()


    fun resetPassword(request: ResetPasswordRequest) = apiRequestManager.requestApi(repo.resetPassword(request),resetPasswordLiveData)
    fun editPassword(request: EditPasswordRequest) = apiRequestManager.requestApi(repo.editPassword(request),editPasswordLiveData)
}