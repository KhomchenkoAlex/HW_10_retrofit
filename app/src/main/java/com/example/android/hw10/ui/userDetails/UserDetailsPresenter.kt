package com.example.android.hw10.ui.userDetails

import com.example.android.hw10.model.User
import com.example.android.hw10.network.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailsPresenter(val view: UserDetailsView) {

    private var userData: User? = null

    fun getGithubUserData(username: String) {
        view.showSpinner()
        NetworkHelper.api.getUserInfo(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                view.hideSpinner()
                if (response.isSuccessful) {
                    userData = response.body()
                    view.showUserData(userData!!)
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {

                view.hideSpinner()
            }
        })
    }
}