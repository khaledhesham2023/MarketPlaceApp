package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("customer_id")
    val customerId: Long? = null,
    @SerializedName("region")
    val region: Region? = null,
    @SerializedName("region_id")
    val regionId: Long? = null,
    @SerializedName("country_id")
    val countryId: String? = null,
    @SerializedName("street")
    val street: List<String>? = null,
    @SerializedName("telephone")
    val telephone: String? = null,
    @SerializedName("postcode")
    val postCode: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("firstname")
    val firstName: String? = null,
    @SerializedName("lastname")
    val lastName: String? = null,
    @SerializedName("default_shipping")
    val defaultShipping:Boolean? = null,
    @SerializedName("default_billing")
    val defaultBilling:Boolean? = null,
    @SerializedName("custom_attributes")
    val customAttributes: List<CustomAttribute>? = null
)