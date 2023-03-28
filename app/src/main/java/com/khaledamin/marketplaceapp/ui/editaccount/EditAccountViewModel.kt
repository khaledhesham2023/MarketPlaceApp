package com.khaledamin.marketplaceapp.ui.editaccount

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khaledamin.marketplaceapp.model.requests.EditProfileRequest
import com.khaledamin.marketplaceapp.model.responses.User
import com.khaledamin.marketplaceapp.ui.base.BaseViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class EditAccountViewModel(application: Application) : BaseViewModel(application) {

    var getProfileLiveData = MutableLiveData<ViewState<User>>()
    var editProfileLiveData = MutableLiveData<ViewState<User>>()

    fun getProfile() = apiRequestManager.requestApi(repo.getProfile(), getProfileLiveData)
    fun editProfile(request: EditProfileRequest) =
        apiRequestManager.requestApi(repo.editProfile(request), editProfileLiveData)
}