package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.CustomAttribute
import com.khaledamin.marketplaceapp.model.MediaGalleryEntry
import com.khaledamin.marketplaceapp.model.ProductAttributes

data class ProductItem(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("sku")
    val sku:String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("attribute_set_id")
    val attributeSetId:Long?,
    @SerializedName("price")
    val price:Double?,
    @SerializedName("status")
    val status:Int?,
    @SerializedName("visibility")
    val visibility:Int?,
    @SerializedName("type_id")
    val typeId:String?,
    @SerializedName("created_at")
    val createdIn:String?,
    @SerializedName("updated_at")
    val updatedIn:String?,
    @SerializedName("weight")
    val weight:Int?,
    @SerializedName("extension_attributes")
    val extensionAttributes: ProductAttributes?,
    @SerializedName("product_links")
    val productLinks:ArrayList<String>?,
    @SerializedName("options")
    val options:ArrayList<String>?,
    @SerializedName("media_gallery_entries")
    val mediaGalleryEntries:ArrayList<MediaGalleryEntry>?,
    @SerializedName("tier_prices")
    val tierPrices:ArrayList<String>?,
    @SerializedName("custom_attributes")
    val customAttributes: ArrayList<CustomAttribute>?
)