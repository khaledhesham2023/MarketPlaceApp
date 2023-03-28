package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class ShippingAmount(
    @SerializedName("free_shipping_amount")
    val freeShippingAmount: Int?
)