package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class BillingAddress(
    @SerializedName("address_type")
    val addressType: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country_id")
    val countryId: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("entity_id")
    val entityId: Long? = null,
    @SerializedName("firstname")
    val firstName: String? = null,
    @SerializedName("lastname")
    val lastName: String? = null,
    @SerializedName("parent_id")
    val parentId: Long? = null,
    @SerializedName("postcode")
    val postCode: String? = null,
    @SerializedName("region")
    val regionName:String? = null,
    @SerializedName("region_code")
    val regionCode:String? = null,
    @SerializedName("region_id")
    val regionId: Long? = null,
    @SerializedName("street")
    val street: List<String>? = null,
    @SerializedName("telephone")
    val telephone: String? = null
)