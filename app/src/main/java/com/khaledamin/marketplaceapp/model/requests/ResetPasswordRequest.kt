package com.khaledamin.marketplaceapp.model.requests

import com.google.gson.annotations.SerializedName

data class ResetPasswordRequest(
    @SerializedName("mobile")
    val mobile:String?,
    @SerializedName("password")
    val password:String?,
    @SerializedName("confirmPassword")
    val confirmPassword:String?,
    @SerializedName("phone_code")
    val phoneCode:String?
)