package com.khaledamin.marketplaceapp.datasource.remote.api

import com.khaledamin.marketplaceapp.model.requests.*
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

    @GET("V1/mage/categories/{catalogId}/products")
    fun getCategoryProducts(
        @Path("catalogId") catalogId:Long,
        @Query("searchCriteria[pageSize]") pageSize: Int,
        @Query("searchCriteria[currentPage]") currentPage: Int,
    ): Single<GetCategoryProductsResponse>

    @GET("V1/mage/home")
    fun getCatalogs(): Single<ArrayList<Catalog>>

    @PUT("V1/mage/customers/password/reset")
    fun resetPassword(@Body request: ResetPasswordRequest): Single<ResetPasswordResponse>

    @PUT("V1/customers/me/password")
    fun editPassword(@Body request: EditPasswordRequest): Single<EditPasswordResponse>

    @GET("V1/mage/notification/history")
    fun getNotifications(): Single<ArrayList<Notification>>

    @GET("V1/mage/products/{productSku}")
    fun getProductDetails(@Path("productSku") productSku: String?): Single<GetProductDetailsResponse>

    @GET("V1/mage/orders/mine/current")
    fun getCurrentOrders(
        @Query("searchCriteria[pageSize]") pageSize: Int?,
        @Query("searchCriteria[currentPage]") currentPage: Int?,
    ): Single<GetOrdersResponse>

    @GET("V1/mage/orders/mine/previous")
    fun getPreviousOrders(
        @Query("searchCriteria[pageSize]") pageSize: Int?,
        @Query("searchCriteria[currentPage]") currentPage: Int?,
    ): Single<GetOrdersResponse>

    @GET("V1/customers/me")
    fun getProfile():Single<User>

    @PUT("V1/customers/me")
    fun editProfile(@Body request:EditProfileRequest):Single<User>
}



