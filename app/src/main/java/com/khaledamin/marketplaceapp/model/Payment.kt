package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Payment(
    @SerializedName("account_status")
    val accountStatus: Any?,
    @SerializedName("additional_information")
    val additionalInformation:List<Any>?,
    @SerializedName("amount_ordered")
    val amountOrdered:Double?,
    @SerializedName("base_amount_ordered")
    val baseAmountOrdered:Double?,
    @SerializedName("base_shipping_amount")
    val baseShippingAmount:Double?,
    @SerializedName("cc_exp_year")
    val ccExpYear:String?,
    @SerializedName("cc_last4")
    val ccLast4:Any?,
    @SerializedName("cc_ss_start_month")
    val ccSsStartMonth:String?,
    @SerializedName("cc_ss_start_year")
    val ccSsStartYear:String?,
    @SerializedName("entity_id")
    val entityId:Long?,
    @SerializedName("method")
    val method:String?,
    @SerializedName("parent_id")
    val parentId:Long?,
    @SerializedName("shipping_amount")
    val shippingAmount:Double?
)