package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Specification(
    @SerializedName("label")
    val label:String?,
    @SerializedName("value")
    val value:String?
)