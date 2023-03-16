package com.khaledamin.marketplaceapp.model.requests

import com.google.gson.annotations.SerializedName

data class SendOTPRequest(
    @SerializedName("phone_code")
    val phoneCode:String?,
    @SerializedName("mobile")
    val mobile:String?
)
