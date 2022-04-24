package com.pdge.pramod.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    val email = MutableLiveData<String>()
    val  password = MutableLiveData<String>()



}