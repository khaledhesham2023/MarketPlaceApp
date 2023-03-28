package com.khaledamin.marketplaceapp.model.requests

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.Customer

data class EditProfileRequest(
    @SerializedName("customer")
    val customer: Customer?
)