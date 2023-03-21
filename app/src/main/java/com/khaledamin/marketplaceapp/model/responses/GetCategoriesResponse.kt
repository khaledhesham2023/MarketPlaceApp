package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName

data class GetCategoriesResponse(
    @SerializedName("id")
    val id:Long?,
    @SerializedName("parent_id")
    val parentId:Long?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("is_active")
    val isActive:Boolean,
    @SerializedName("position")
    val position:Int?,
    @SerializedName("level")
    val level:Int?,
    @SerializedName("product_count")
    val productCount:Int?,
    @SerializedName("url_key")
    val urlKey:String?,
    @SerializedName("image")
    val image:String?,
    @SerializedName("icon")
    val icon:String?,
    @SerializedName("thumbnail")
    val thumbnail:String?,
    @SerializedName("include_in_menu")
    val includeInMenu:Boolean,
    @SerializedName("children_data")
    val childrenData:ArrayList<GetCategoriesResponse>,
    var isSelected:Boolean
)