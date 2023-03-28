package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Total(
    @SerializedName("base_shipping_amount")
    val baseShippingAmount:Int?,
    @SerializedName("base_shipping_discount_amount")
    val baseShippingDiscountAmount:Int?,
    @SerializedName("base_shipping_discount_tax_compensation_amnt")
    val baseShippingDiscountTaxCompensationAmnt:Int?,
    @SerializedName("base_shipping_incl_tax")
    val baseShippingInclTax:Int?,
    @SerializedName("base_shipping_tax_amount")
    val baseShippingTaxAmount:Int?,
    @SerializedName("shipping_amount")
    val shippingAmount:Int?,
    @SerializedName("shipping_discount_amount")
    val shippingDiscountAmount:Int?,
    @SerializedName("shipping_discount_tax_compensation_amount")
    val shippingDiscountTaxCompensationAmount:Int?,
    @SerializedName("shipping_incl_tax")
    val shippingInclTax:String?,
    @SerializedName("shipping_tax_amount")
    val shippingTaxAmount:Int?
)

