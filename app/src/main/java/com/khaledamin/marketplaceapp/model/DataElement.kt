package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class DataElement(
    @SerializedName("id")
    val id:String?,
    @SerializedName("category_thumbnail")
    val categoryThumbnail:String?,
    @SerializedName("name")
    val name:String?
)

