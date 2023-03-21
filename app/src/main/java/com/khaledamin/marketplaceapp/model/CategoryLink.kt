package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class CategoryLink(
    @SerializedName("position")
    val position:Int?,
    @SerializedName("category_id")
    val categoryId:String?
)