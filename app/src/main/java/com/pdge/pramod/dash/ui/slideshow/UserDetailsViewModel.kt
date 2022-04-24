package com.pdge.pramod.dash.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdge.pramod.repository.UserResponse

class UserDetailsViewModel : ViewModel() {
    private var userDetailsRepository: UserDetailsRepository? = null

    fun getUserDetails(): LiveData<UserResponse?>? {
        userDetailsRepository = UserDetailsRepository()
        return userDetailsRepository!!.userDetails()
    }
}