package com.khaledamin.marketplaceapp.datasource.remote.repo

import com.khaledamin.marketplaceapp.datasource.remote.api.Api

abstract class BaseRepo() {

    abstract val apiInterfaceClass:Class<Api>

    abstract val sharedPrefRepo:SharedPrefRepo

}