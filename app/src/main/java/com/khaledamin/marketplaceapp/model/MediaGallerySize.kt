package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class MediaGallerySize(
    @SerializedName("type")
    val type:String?,
    @SerializedName("full")
    val full:String?,
    @SerializedName("thumbnail")
    val thumbnail:String?,
    @SerializedName("embed_url")
    val embedUrl:String?
)