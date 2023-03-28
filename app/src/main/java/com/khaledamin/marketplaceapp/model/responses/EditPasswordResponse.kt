package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName

data class EditPasswordResponse(
    @SerializedName("status")
    val status:Int?,
    @SerializedName("success")
    val success:Boolean?,
    @SerializedName("message")
    val message:String?
)