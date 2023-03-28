package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Shipping(
    @SerializedName("address")
    val address: BillingAddress?,
    @SerializedName("method")
    val method:String?,
    @SerializedName("total")
    val total:Total?
)