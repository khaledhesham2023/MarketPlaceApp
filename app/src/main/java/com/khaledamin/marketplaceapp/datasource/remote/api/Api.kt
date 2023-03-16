package com.khaledamin.marketplaceapp.datasource.remote.api

import com.khaledamin.marketplaceapp.model.requests.SendOTPRequest
import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.model.requests.VerifyRequest
import com.khaledamin.marketplaceapp.model.responses.SendOTPResponse
import com.khaledamin.marketplaceapp.model.responses.SignupResponse
import com.khaledamin.marketplaceapp.model.responses.User
import com.khaledamin.marketplaceapp.model.responses.VerifyResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query


interface Api {

    @POST("V1/mage/customer/token")
    suspend fun getLoginResult(
        @Header("fb-token") deviceToken: String,
        @Query("username") username: String,
        @Query("password") password: String,
    ): Single<User>

    @POST("V1/customers")
    suspend fun getSignUpResult(@Body request: SignupRequest): Single<SignupResponse>

    @POST("V1/mage/otp/send")
    suspend fun sendOTP(@Body request: SendOTPRequest):Single<SendOTPResponse>

    @POST("V1/mage/otp/verify")
    suspend fun verifyCode(@Body request: VerifyRequest):Single<VerifyResponse>

    @POST("V1/mage/otp/verify-customer")
    suspend fun verifyCustomer(@Body request: VerifyRequest):Single<VerifyResponse>


}



