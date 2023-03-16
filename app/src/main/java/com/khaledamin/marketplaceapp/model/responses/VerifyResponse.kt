package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName

data class VerifyResponse(
    @SerializedName("code")
    val code:String?,
    @SerializedName("status")
    val status:String?,
    @SerializedName("entity_id")
    val entityId:String?,
    @SerializedName("message")
    val message:String?
)