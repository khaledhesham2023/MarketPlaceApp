package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("amount_refunded")
    val amountRefunded: Double?,
    @SerializedName("applied_rule_ids")
    val appliedRuleIds: String?,
    @SerializedName("base_amount_refunded")
    val baseAmountRefunded: Double?,
    @SerializedName("base_discount_amount")
    val baseDiscountAmount: Double?,
    @SerializedName("base_discount_invoiced")
    val baseDiscountInvoiced: Double?,
    @SerializedName("base_discount_tax_compensation_amount")
    val baseDiscountTaxCompensationAmount: Double?,
    @SerializedName("base_original_price")
    val baseOriginalPrice: Double?,
    @SerializedName("base_price")
    val basePrice: Double?,
    @SerializedName("base_price_incl_tax")
    val basePriceInclTax: Double?,
    @SerializedName("base_row_invoiced")
    val baseRowInvoiced: Double?,
    @SerializedName("base_row_total")
    val baseRowTotal: Double?,
    @SerializedName("base_row_total_incl_tax")
    val baseRowTotalInclTax: Double?,
    @SerializedName("base_tax_amount")
    val baseTaxAmount: Double?,
    @SerializedName("base_tax_invoiced")
    val baseTaxInvoiced: Double?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("discount_amount")
    val discountAmount: Double?,
    @SerializedName("discount_invoiced")
    val discountInvoiced: Double?,
    @SerializedName("discount_percent")
    val discountPercent: Double?,
    @SerializedName("discount_tax_compensation_amount")
    val discountTaxCompensationAmount: Double?,
    @SerializedName("free_shipping")
    val freeShipping: Double?,
    @SerializedName("is_qty_decimal")
    val isQtyDecimal: Int?,
    @SerializedName("is_virtual")
    val isVirtual: Int?,
    @SerializedName("item_id")
    val itemId: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("no_discount")
    val noDiscount: Int?,
    @SerializedName("order_id")
    val orderId: Long?,
    @SerializedName("original_price")
    val originalPrice: Double?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("price_incl_tax")
    val priceInclTax: Double?,
    @SerializedName("product_id")
    val productId: Long?,
    @SerializedName("product_type")
    val productType: String?,
    @SerializedName("qty_canceled")
    val qtyCanceled: Int?,
    @SerializedName("qty_invoiced")
    val qtyInvoiced: Int?,
    @SerializedName("qty_ordered")
    val qtyOrdered: Int?,
    @SerializedName("qty_refunded")
    val qtyRefunded: Int?,
    @SerializedName("qty_shipped")
    val qtyShipped: Int?,
    @SerializedName("quote_item_id")
    val quoteItemId: Double?,
    @SerializedName("row_invoiced")
    val rowInvoiced: Double?,
    @SerializedName("row_total")
    val rowTotal: Double?,
    @SerializedName("row_total_incl_tax")
    val rowTotalInclTax: Double?,
    @SerializedName("row_weight")
    val rowWeight: Double?,
    @SerializedName("sku")
    val sku: String?,
    @SerializedName("store_id")
    val storeId: Long?,
    @SerializedName("tax_amount")
    val taxAmount: Double?,
    @SerializedName("tax_invoiced")
    val taxInvoiced: Double?,
    @SerializedName("tax_percent")
    val taxPercent: Double?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("weight")
    val weight: Double?,
    )