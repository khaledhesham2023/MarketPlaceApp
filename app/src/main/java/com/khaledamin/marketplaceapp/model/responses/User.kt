package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.Address
import com.khaledamin.marketplaceapp.model.CustomAttribute
import com.khaledamin.marketplaceapp.model.ExtensionAttributes

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
){
    fun getPhone():String{
        var phone = ""
        for(attribute in customAttributes){
            if (attribute.key == "customer_mobile")
                phone = attribute.value!!
        }
        return phone
    }
}