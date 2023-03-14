package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.CustomAttribute
import com.khaledamin.marketplaceapp.model.ExtensionAttributes

data class SignupResponse(
    @SerializedName("id")
    val id:Long?,
    @SerializedName("group_id")
    val groupId:Long?,
    @SerializedName("created_at")
    val createdAt:String?,
    @SerializedName("updated_at")
    val updatedAt:String?,
    @SerializedName("created_in")
    val createdIn:String?,
    @SerializedName("email")
    val email:String?,
    @SerializedName("firstname")
    val firstname:String?,
    @SerializedName("lastname")
    val lastname:String?,
    @SerializedName("store_id")
    val storeId:Long?,
    @SerializedName("website_id")
    val websiteId:Long?,
    @SerializedName("addresses")
    val addresses:ArrayList<String>?,
    @SerializedName("disable_auto_group_change")
    val disableAutoGroupChange:Int?,
    @SerializedName("extension_attributes")
    val extensionAttribute: ExtensionAttributes?,
    @SerializedName("custom_attributes")
    val customAttributes: ArrayList<CustomAttribute>?
)