package com.khaledamin.marketplaceapp.datasource.remote.api

import com.khaledamin.marketplaceapp.model.requests.SendOTPRequest
import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.model.requests.VerifyRequest
import com.khaledamin.marketplaceapp.model.responses.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*


interface Api {

    @POST("V1/mage/customer/token")
    fun getLoginResult(
        @Header("fb-token") deviceToken: String,
        @Query("username") username: String,
        @Query("password") password: String,
    ): Single<User>

    @POST("V1/customers")
    fun getSignUpResult(@Body request: SignupRequest): Single<SignupResponse>

    @POST("V1/mage/otp/send")
    fun sendOTP(@Body request: SendOTPRequest): Single<SendOTPResponse>

    @POST("V1/mage/otp/verify")
    fun verifyCode(@Body request: VerifyRequest): Single<VerifyResponse>

    @POST("V1/mage/otp/verify-customer")
    fun verifyCustomer(@Body request: VerifyRequest): Single<VerifyResponse>

    @GET("V1/mage/categories")
    fun getCategories(): Single<GetCategoriesResponse>

    @GET("/V1/mage/categories/{categoryId}/products?searchCriteria[pageSize]=50&searchCriteria[currentPage]=1")
    fun getCategoryProducts(
        @Path("categoryId") categoryId: Long,
        @Query("searchCriteria[pageSize]") pageSize:Int,
        @Query("searchCriteria[currentPage]") currentPage:Int
    )

    @GET("V1/mage/home")
    fun getCatalogs():Single<ArrayList<Catalog>>


}



