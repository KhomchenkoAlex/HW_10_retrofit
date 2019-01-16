package com.example.android.hw10.network

import okhttp3.Interceptor
import okhttp3.Response


class AuthHeaderInterceptor: Interceptor {

    private val github_token = "07262d1b851957ec3e7e290cc67cde7ff12cd526"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .header("Authorization", "token ${github_token}")
            .build()
        return chain.proceed(newRequest)
    }
}