package com.khaledamin.marketplaceapp.datasource.remote.api

import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.model.responses.SignupResponse
import com.khaledamin.marketplaceapp.model.responses.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query


interface Api {

    @POST("V1/mage/customer/token")
    fun getLoginResult(
        @Header("fb-token") deviceToken: String,
        @Query("username") username: String,
        @Query("password") password: String,
    ): Single<User>

    @POST("V1/customers")
    fun getSignUpResult(@Body request: SignupRequest): Single<SignupResponse>
}



