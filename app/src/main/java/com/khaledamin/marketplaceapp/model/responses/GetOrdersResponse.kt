package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.SearchCriteria

data class GetOrdersResponse(
    @SerializedName("items")
    val items:ArrayList<Order>?,
    @SerializedName("search_criteria")
    val searchCriteria: SearchCriteria?,
    @SerializedName("total_count")
    val totalCount:Int?
)


