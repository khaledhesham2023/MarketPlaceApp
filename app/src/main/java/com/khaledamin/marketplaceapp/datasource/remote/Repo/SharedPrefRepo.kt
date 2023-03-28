package com.khaledamin.marketplaceapp.datasource.remote.Repo

import android.content.Context
import com.google.gson.Gson
import com.khaledamin.marketplaceapp.model.responses.User
import com.khaledamin.marketplaceapp.utils.Constants

class SharedPrefRepo(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("MARKETAPP", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private val gson = Gson()


    fun saveUser(user: User?) = editor.putString(Constants.USER, gson.toJson(user)).apply()

    fun getUser(): User =
        gson.fromJson(sharedPreferences.getString(Constants.USER, ""), User::class.java)

    fun setLoggedIn(isLoggedIn: Boolean) =
        editor.putBoolean(Constants.USER_LOGGED_IN, isLoggedIn).apply()

    fun isLoggedIn(): Boolean = sharedPreferences.getBoolean(Constants.USER_LOGGED_IN, false)

    fun setBearerToken(token:String?) = sharedPreferences.edit().putString(Constants.BEARER_TOKEN,token).apply()

    fun getBearerToken():String? = sharedPreferences.getString(Constants.BEARER_TOKEN,"")

    fun savePhoneNumber(phoneEntry:String?) = sharedPreferences.edit().putString(Constants.PHONE_NUMBER_ENTRY,phoneEntry).apply()

    fun getPhoneNumber():String? = sharedPreferences.getString(Constants.PHONE_NUMBER,"")

    fun savePassword(password:String) = sharedPreferences.edit().putString(Constants.USER_PASSWORD,password).apply()

    fun getPassword():String? = sharedPreferences.getString(Constants.USER_PASSWORD,"")




}