package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.*

data class GetProductDetailsResponse(
    @SerializedName("id")
    val productId: Long?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("price")
    val price: Price?,
    @SerializedName("sku")
    val sku: String?,
    @SerializedName("sale_percent")
    val salePercent: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("category_name")
    val categoryName: String?,
    @SerializedName("added_to_wishlist")
    val addedToWishList: Int?,
    @SerializedName("added_to_cart")
    val addedToCart: Int?,
    @SerializedName("quote_qty")
    val quoteQty: Int?,
    @SerializedName("reviews_rate")
    val reviewsRate: Int?,
    @SerializedName("specification")
    val specifications: ArrayList<Specification>,
    @SerializedName("reviews")
    val reviews: ArrayList<String>?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("weight_unit")
    val weightUnit: String?,
    @SerializedName("tofaha_weight")
    val marketWeight: String?,
    @SerializedName("image_resized")
    val imageResized: String?,
    @SerializedName("type_id")
    val typeId: String?,
    @SerializedName("is_salable")
    val isSalable: Int?,
    @SerializedName("media_gallery_sizes")
    val mediaGallerySizes: ArrayList<MediaGallerySize>?,
    @SerializedName("url_path")
    val urlPath:String?,
    @SerializedName("tier_prices")
    val tierPrices:ArrayList<String>?,
    @SerializedName("stock")
    val stock: Stock?,
    @SerializedName("product_links")
    val productLinks:ArrayList<String>?,
    @SerializedName("options")
    val options:ArrayList<String>?,
    @SerializedName("extension_attributes")
    val shippingAmount: ShippingAmount?
    )