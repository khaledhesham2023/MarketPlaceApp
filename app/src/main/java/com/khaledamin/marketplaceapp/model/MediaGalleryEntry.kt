package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class MediaGalleryEntry(
    @SerializedName("id")
    val id:Long?,
    @SerializedName("media_type")
    val mediaType:String?,
    @SerializedName("label")
    val label:String?,
    @SerializedName("position")
    val position:Int?,
    @SerializedName("disabled")
    val disabled:Boolean,
    @SerializedName("types")
    val types:ArrayList<String>?,
    @SerializedName("file")
    val file:String?
)