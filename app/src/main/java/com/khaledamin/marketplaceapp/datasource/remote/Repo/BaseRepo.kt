package com.khaledamin.marketplaceapp.datasource.remote.Repo

import android.content.Context
import com.khaledamin.marketplaceapp.datasource.remote.api.Api

abstract class BaseRepo() {

    abstract val apiInterfaceClass:Class<Api>

    abstract val sharedPrefRepo:SharedPrefRepo

}