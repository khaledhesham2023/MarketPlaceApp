package com.khaledamin.marketplaceapp.model.requests

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.Customer

data class SignupRequest(
    @SerializedName("customer")
    val customer: Customer?,
    @SerializedName("password")
    val password:String?,
    @SerializedName("confrimPassword")
    val confirmPassword:String?
)
