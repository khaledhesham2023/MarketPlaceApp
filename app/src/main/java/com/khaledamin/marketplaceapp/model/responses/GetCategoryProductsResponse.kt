package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName

data class GetCategoryProductsResponse(
    @SerializedName("items")
    val items:ArrayList<ProductItem>
)