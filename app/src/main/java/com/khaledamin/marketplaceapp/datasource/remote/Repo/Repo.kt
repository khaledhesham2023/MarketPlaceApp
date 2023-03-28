package com.khaledamin.marketplaceapp.datasource.remote.Repo

import android.app.Application
import com.khaledamin.marketplaceapp.datasource.remote.api.Api
import com.khaledamin.marketplaceapp.model.requests.*
import com.khaledamin.marketplaceapp.utils.Constants
import com.khaledamin.marketplaceapp.utils.makeHTTP
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repo(val application: Application) : BaseRepo() {

    override val apiInterfaceClass: Class<Api>
        get() = Api::class.java
    override val sharedPrefRepo: SharedPrefRepo
        get() = SharedPrefRepo(application.applicationContext)

    private val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(makeHTTP(sharedPrefRepo))
        .build()
    private val api = retrofit.create(apiInterfaceClass)


    fun login(header: String, username: String, password: String) =
        api.getLoginResult(header, username, password)

    fun signup(request: SignupRequest) = api.getSignUpResult(request)

    fun sendOTP(request: SendOTPRequest) = api.sendOTP(request)

    fun verifyCode(request: VerifyRequest) = api.verifyCode(request)

    fun verifyCustomer(request: VerifyRequest) = api.verifyCustomer(request)

    fun getCategories() = api.getCategories()

    fun getCategoryProducts(
        catalogId:Long,
        pageSize: Int,
        currentPage: Int,
    ) = api.getCategoryProducts(catalogId,pageSize, currentPage)

    fun getCatalogs() = api.getCatalogs()

    fun resetPassword(request: ResetPasswordRequest) = api.resetPassword(request)

    fun editPassword(request: EditPasswordRequest) = api.editPassword(request)

    fun getNotifications() = api.getNotifications()

    fun getProductDetails(sku: String?) = api.getProductDetails(sku)

    fun getCurrentOrders(pageSize:Int?,currentPage:Int?) = api.getCurrentOrders(pageSize, currentPage)

    fun getPreviousOrders(pageSize: Int?,currentPage: Int?) = api.getPreviousOrders(pageSize, currentPage)

    fun getProfile() = api.getProfile()

    fun editProfile(request:EditProfileRequest) = api.editProfile(request)


}