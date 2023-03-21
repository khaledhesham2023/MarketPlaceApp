package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class Stock(
  @SerializedName("qty")
  val qty:Int?,
  @SerializedName("is_in_stock")
  val isInStock:Boolean,
  @SerializedName("min_qty")
  val minQty:Int
)