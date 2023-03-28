package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class ShippingAssignment(
    @SerializedName("items")
    val items:ArrayList<Item>?,
    @SerializedName("shipping")
    val shipping:Shipping?
)
