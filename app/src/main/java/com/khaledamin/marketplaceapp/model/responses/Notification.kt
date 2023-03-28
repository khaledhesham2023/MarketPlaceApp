package com.khaledamin.marketplaceapp.model.responses

import com.google.gson.annotations.SerializedName

data class Notification(
    @SerializedName("body")
    val body:String?,
    @SerializedName("created_at")
    val createdAt:String?,
    @SerializedName("customer_id")
    val customerId:Long?,
    @SerializedName("device_type")
    val deviceType:String?,
    @SerializedName("icon")
    val icon:String?,
    @SerializedName("id")
    val id:Long?,
    @SerializedName("model")
    val model:String?,
    @SerializedName("model_id")
    val modelId:Long?,
    @SerializedName("notification_id")
    val notificationId:Long?,
    @SerializedName("operating_system")
    val operatingSystem:String?,
    @SerializedName("subject")
    val subject:String?,
    @SerializedName("subscriber_id")
    val subscriberId: Long?,
    @SerializedName("token")
    val token:String?,
    @SerializedName("updated_at")
    val updatedAt:String?,
    @SerializedName("url")
    val url:String?
)