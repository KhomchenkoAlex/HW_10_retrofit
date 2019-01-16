package com.example.android.hw10.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object NetworkHelper {

    private const val BASE_URL = "https://api.github.com"

    private val loggingInterceptor by lazy {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    private val authInterceptor by lazy {
        AuthHeaderInterceptor()
    }

    private val httpClient by lazy {
        OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
            addInterceptor(authInterceptor)
        }.build()
    }

    private val builder by lazy { Retrofit.Builder().addConverterFactory(JacksonConverterFactory.create()) }

    private fun <ApiInterface> createService(serviceClass: Class<ApiInterface>) = builder
        .baseUrl(BASE_URL)
        .client(httpClient)
        .build()
        .create(serviceClass)

    val api: Api by lazy { createService(Api::class.java) }
}