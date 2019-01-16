package com.example.android.hw10.network

import com.example.android.hw10.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/users/{username}")
    fun getUserInfo(@Path("username") username: String): Call<User>
}