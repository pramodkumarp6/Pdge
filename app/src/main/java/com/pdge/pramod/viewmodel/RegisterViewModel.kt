package com.pdge.pramod.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    val Name = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val gender = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val mobile = MutableLiveData<String>()
    val address = MutableLiveData<String>()


    fun onClickRegister() {

    }
}