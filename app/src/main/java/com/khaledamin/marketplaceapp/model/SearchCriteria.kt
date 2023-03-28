package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class SearchCriteria(
    @SerializedName("filter_groups")
    val filterGroups:ArrayList<String>?,
    @SerializedName("page_size")
    val pageSize:Int?,
    @SerializedName("current_page")
    val currentPage:Int?
)