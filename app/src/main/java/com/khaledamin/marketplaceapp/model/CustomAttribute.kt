package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class CustomAttribute(
    @SerializedName("attribute_code")
    val key:String?,
    @SerializedName("value")
    var value:String?
)