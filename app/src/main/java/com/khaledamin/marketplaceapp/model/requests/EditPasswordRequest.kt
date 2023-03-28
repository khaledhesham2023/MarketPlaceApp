package com.khaledamin.marketplaceapp.model.requests

import com.google.gson.annotations.SerializedName

data class EditPasswordRequest(
    @SerializedName("currentPassword")
    val currentPassword:String?,
    @SerializedName("newPassword")
    val newPassword:String?,
    @SerializedName("confirmNewPassword")
    val confirmNewPassword:String?
)