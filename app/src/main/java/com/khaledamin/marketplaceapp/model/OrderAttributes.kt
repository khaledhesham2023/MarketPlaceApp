package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName
import java.util.Currency

data class OrderAttributes(
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("shipping_address")
    val shippingAddress:BillingAddress?,
    @SerializedName("shipping_assignments")
    val shippingAssignments:ArrayList<ShippingAssignment>?
)


