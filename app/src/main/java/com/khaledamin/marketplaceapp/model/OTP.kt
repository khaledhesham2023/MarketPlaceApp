package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class OTP(
    @SerializedName("mobile")
    val mobile:String?,
    @SerializedName("otp_code")
    val otpCode:String?,
    @SerializedName("phone_code")
    val phoneCode:String?,
    @SerializedName("sms_id")
    val smsId:String?
)