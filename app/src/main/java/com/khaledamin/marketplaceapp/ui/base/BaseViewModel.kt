package com.khaledamin.marketplaceapp.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.khaledamin.marketplaceapp.datasource.remote.repo.Repo
import com.khaledamin.marketplaceapp.utils.ApiRequestManager

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    protected var apiRequestManager = ApiRequestManager(application.applicationContext)

    protected var repo = Repo(application)


}