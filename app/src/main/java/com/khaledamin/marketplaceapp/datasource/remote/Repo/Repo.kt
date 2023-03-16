package com.khaledamin.marketplaceapp.datasource.remote.Repo

import com.khaledamin.marketplaceapp.datasource.remote.api.Api
import com.khaledamin.marketplaceapp.model.requests.SendOTPRequest
import com.khaledamin.marketplaceapp.model.requests.SignupRequest
import com.khaledamin.marketplaceapp.model.requests.VerifyRequest
import com.khaledamin.marketplaceapp.utils.Constants
import com.khaledamin.marketplaceapp.utils.makeHTTP
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repo() : BaseRepo() {

    override val apiInterfaceClass: Class<Api>
        get() = Api::class.java

    private val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(makeHTTP())
        .build()
    private val api = retrofit.create(apiInterfaceClass)


    suspend fun login(header: String, username: String, password: String) =
        api.getLoginResult(header, username, password)

    suspend fun signup(request: SignupRequest) = api.getSignUpResult(request)

    suspend fun sendOTP(request: SendOTPRequest) = api.sendOTP(request)

    suspend fun verifyCode(request: VerifyRequest) = api.verifyCode(request)

    suspend fun verifyCustomer(request: VerifyRequest) = api.verifyCustomer(request)



}