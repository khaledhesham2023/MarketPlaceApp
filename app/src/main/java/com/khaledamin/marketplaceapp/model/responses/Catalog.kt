package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.DataElement

data class Catalog(
    @SerializedName("type")
    val type:String?,
    @SerializedName("title")
    val title:String?,
    @SerializedName("data_elements")
    val dataElements:List<DataElement>?
)
