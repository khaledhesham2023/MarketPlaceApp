package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName
import com.khaledamin.marketplaceapp.model.*
import java.io.Serializable

data class Order(
    @SerializedName("applied_rule_ids")
    val appliedRuleIds: String?,
    @SerializedName("base_currency_code")
    val baseCurrencyCode: String?,
    @SerializedName("base_discount_amount")
    val baseDiscountAmount: Double?,
    @SerializedName("base_discount_tax_compensation_amount")
    val baseDiscountTaxCompensationAmount: Double?,
    @SerializedName("base_grand_total")
    val baseGrandTotal: Double?,
    @SerializedName("base_shipping_amount")
    val baseShippingAmount: Double?,
    @SerializedName("base_shipping_discount_amount")
    val baseShippingDiscountAmount: Double?,
    @SerializedName("base_shipping_discount_tax_compensation_amnt")
    val baseShippingDiscountTaxCompensationAmnt: Double?,
    @SerializedName("base_shipping_incl_tax")
    val baseShippingInclTax: Double?,
    @SerializedName("base_shipping_tax_amount")
    val baseShippingTaxAmount: Double?,
    @SerializedName("base_subtotal")
    val baseSubtotal: Double?,
    @SerializedName("base_subtotal_incl_tax")
    val baseSubtotalInclTax: Double?,
    @SerializedName("base_tax_amount")
    val baseTaxAmount: Double?,
    @SerializedName("base_to_global_rate")
    val baseToGlobalRate: Double?,
    @SerializedName("base_to_order_rate")
    val rateToOrderRate: Double?,
    @SerializedName("base_total_due")
    val baseTotalDue: Double?,
    @SerializedName("billing_address")
    val billingAddress: BillingAddress?,
    @SerializedName("billing_address_id")
    val billingAddressId: Long?,
    @SerializedName("coupon_code")
    val couponCode: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("customer_email")
    val customerEmail: String?,
    @SerializedName("customer_firstname")
    val customerFirstName: String?,
    @SerializedName("customer_group_id")
    val customerGroupId: Long?,
    @SerializedName("customer_id")
    val customerId: Long?,
    @SerializedName("customer_is_guest")
    val customerIsGuest: Int?,
    @SerializedName("customer_lastname")
    val customerLastname: String?,
    @SerializedName("customer_note_notify")
    val customerNoteNotify: Double?,
    @SerializedName("discount_amount")
    val discountAmount: Double?,
    @SerializedName("discount_description")
    val discountDescription: String?,
    @SerializedName("discount_tax_compensation_amount")
    val discountTaxCompensationAmount: Double?,
    @SerializedName("entity_id")
    val entityId: Long?,
    @SerializedName("extension_attributes")
    val orderAttributes: OrderAttributes?,
    @SerializedName("global_currency_code")
    val globalCurrencyCode: String?,
    @SerializedName("grand_total")
    val grandTotal: Double?,
    @SerializedName("increment_id")
    val incrementId: String?,
    @SerializedName("is_virtual")
    val isVirtual: Double?,
    @SerializedName("items")
    val items: ArrayList<Item>,
    @SerializedName("order_currency_code")
    val orderCurrencyCode:String?,
    @SerializedName("payment")
    val payment: Payment,
    @SerializedName("protect_code")
    val protectCode:String?,
    @SerializedName("quote_id")
    val quoteId:Long?,
    @SerializedName("remote_ip")
    val remoteIp:String?,
    @SerializedName("shipping_amount")
    val shippingAmount: Double?,
    @SerializedName("shipping_description")
    val shippingDescription:String?,
    @SerializedName("shipping_discount_amount")
    val shippingDiscountAmount:Double?,
    @SerializedName("shipping_discount_tax_compensation_amount")
    val shippingDiscountTaxCompensationAmount:Double?,
    @SerializedName("shipping_incl_tax")
    val shippingInclTax:Double?,
    @SerializedName("shipping_tax_amount")
    val shippingTaxAmount:Double?,
    @SerializedName("state")
    val state:String?,
    @SerializedName("orderStatus")
    val orderStatus:String?,
    @SerializedName("status")
    val status:String?,
    @SerializedName("status_histories")
    val statusHistories:ArrayList<Any>?,
    @SerializedName("store_currency_code")
    val storeCurrencyCode:String?,
    @SerializedName("store_id")
    val storeId:Long?,
    @SerializedName("store_name")
    val storeName:String?,
    @SerializedName("store_to_base_rate")
    val storeToBaseRate:Double?,
    @SerializedName("store_to_order_rate")
    val storeToOrderRate:Double?,
    @SerializedName("subtotal")
    val subtotal:Double?,
    @SerializedName("subtotal_incl_tax")
    val subtotalInclTax:Double?,
    @SerializedName("tax_amount")
    val taxAmount:Double?,
    @SerializedName("total_due")
    val totalDue:Double?,
    @SerializedName("total_item_count")
    val totalItemCount:Double?,
    @SerializedName("total_qty_ordered")
    val totalQtyOrdered:Double?,
    @SerializedName("updated_at")
    val updatedAt:String?,
    @SerializedName("weight")
    val weight:Double?,
    @SerializedName("x_forwarded_for")
    val xForwardedFor:String?,
    @SerializedName("currentStatus")
    val currentStatus:String?
): Serializable


