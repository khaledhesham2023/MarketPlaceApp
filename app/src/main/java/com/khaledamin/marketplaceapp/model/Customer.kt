package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("custom_attributes")
    val customAttributes: ArrayList<CustomAttribute>,
    @SerializedName("email")
    val email:String?,
    @SerializedName("firstname")
    val firstname:String?,
    @SerializedName("lastname")
    val lastname:String?,
    @SerializedName("website_id")
    val websiteId:Long?
)

