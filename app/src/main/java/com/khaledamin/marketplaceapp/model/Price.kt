package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("regular_price")
    val regularPrice:Double?,
    @SerializedName("special_price")
    val specialPrice:Double?,
    @SerializedName("min_tier_price")
    val minTierPrice:Double?,
    @SerializedName("sale_percent")
    val salePercent:Double?
)