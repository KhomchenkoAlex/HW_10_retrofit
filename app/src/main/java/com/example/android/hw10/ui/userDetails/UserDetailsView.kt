package com.example.android.hw10.ui.userDetails

import com.example.android.hw10.model.User

interface UserDetailsView {
    fun showUserData(user: User)
    fun showSpinner()
    fun hideSpinner()
}