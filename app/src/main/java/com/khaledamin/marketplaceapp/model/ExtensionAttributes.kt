package com.khaledamin.marketplaceapp.model

import com.google.gson.annotations.SerializedName

data class ExtensionAttributes(
    @SerializedName("is_subscribed")
    val isSubscribed: Boolean,
    @SerializedName("newsletter_subscriber")
    val newsletterSubscriber: Boolean,
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("sms_id")
    val smsId:Long? = null
)