package com.khaledamin.marketplaceapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.khaledamin.marketplaceapp.datasource.remote.repo.SharedPrefRepo
import okhttp3.Interceptor
import okhttp3.OkHttpClient

fun isInternetConnected(context: Context): Boolean {
    val connectivityManager =
        context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val network = connectivityManager.activeNetwork
        if (network != null) {
            val capabilities = connectivityManager.getNetworkCapabilities(network)
            capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || capabilities.hasTransport(
                NetworkCapabilities.TRANSPORT_CELLULAR) || capabilities.hasTransport(
                NetworkCapabilities.TRANSPORT_ETHERNET))
        } else {
            false
        }
    } else {
        val networkInfo = connectivityManager.activeNetworkInfo
        networkInfo != null && networkInfo.isConnected
    }
}

fun makeHTTP(sharedPrefRepo: SharedPrefRepo): OkHttpClient {
    val okHttpClient = OkHttpClient.Builder().addInterceptor(Interceptor {
        val request = it.request()
        val url = request.url().toString()
        if (url.endsWith("customers/me/password") || url.endsWith("mage/notification/history") || url.contains(
                "V1/mage/orders/mine/previous") || url.contains("V1/mage/orders/mine/current") || url.contains("V1/customers/me")
        ) {
            val newRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer ${sharedPrefRepo.getBearerToken()}").build()
            it.proceed(newRequest)
        } else {
            it.proceed(request)
        }
    }).build()

    return okHttpClient

}