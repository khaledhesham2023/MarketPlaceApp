package com.khaledamin.marketplaceapp.model.requests

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.OTP

data class VerifyRequest(
    @SerializedName("otp")
    val otp: OTP
)