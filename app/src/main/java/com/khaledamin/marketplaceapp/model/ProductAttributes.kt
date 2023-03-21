package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class ProductAttributes(
    @SerializedName("website_ids")
    val websiteIds: ArrayList<String>?,
    @SerializedName("category_links")
    val categoryLinks: ArrayList<CategoryLink>?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("weight_unit")
    val weightUnit: String?,
    @SerializedName("tofaha_weight")
    val marketWeight: String?,
    @SerializedName("price")
    val price: Price?,
    @SerializedName("stock")
    val stock: Stock?,
    @SerializedName("thumbnail")
    val thumbnail:String?,
    @SerializedName("image")
    val image:String?,
    @SerializedName("added_to_wishlist")
    val addedToWishList:Int?
)