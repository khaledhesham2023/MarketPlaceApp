package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("group_id")
    val groupId: Int? = null,
    @SerializedName("default_billing")
    val defaultBilling: String? = null,
    @SerializedName("default_shipping")
    val defaultShipping: String? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("created_in")
    val createdIn: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("firstname")
    val firstName: String? = null,
    @SerializedName("lastname")
    val lastName: String,
    @SerializedName("gender")
    val gender: Int? = null,
    @SerializedName("store_id")
    val storeId: Long? = null,
    @SerializedName("taxvat")
    val taxvat: String? = null,
    @SerializedName("website_id")
    val websiteId: Long? = null,
    @SerializedName("addresses")
    val addresses: List<Address>? = null,
    @SerializedName("disable_auto_group_change")
    val disableAutoGroupChange: Int? = null,
    @SerializedName("extension_attributes")
    val extensionAttributes: ExtensionAttributes,
    @SerializedName("custom_attributes")
    val customAttributes: List<CustomAttribute>
)

data class ExtensionAttributes(
    @SerializedName("is_subscribed")
    val isSubscribed: Boolean,
    @SerializedName("newsletter_subscriber")
    val newsletterSubscriber: Boolean,
    @SerializedName("token")
    val token: String? = null
)

data class CustomAttribute(
    @SerializedName("attribute_code")
    val attributeCode: String? = null,
    @SerializedName("value")
    val value: String? = null
)

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
    @SerializedName("custom_attributes")
    val customAttributes: List<CustomAttribute>
)

data class Region(
    @SerializedName("region_code")
    val regionCode: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("region_id")
    val regionId: String? = null
)



