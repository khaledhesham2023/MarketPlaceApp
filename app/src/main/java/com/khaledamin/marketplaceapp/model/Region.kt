package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Region(
    @SerializedName("region_code")
    val regionCode: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("region_id")
    val regionId: String? = null
)