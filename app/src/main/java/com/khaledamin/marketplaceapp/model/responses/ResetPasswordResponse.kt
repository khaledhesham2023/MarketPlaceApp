package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse(
    @SerializedName("code")
    val code:String?,
    @SerializedName("entity_id")
    val entityId:Long?,
    @SerializedName("message")
    val message:String?,
    @SerializedName("status")
    val status:Boolean
)