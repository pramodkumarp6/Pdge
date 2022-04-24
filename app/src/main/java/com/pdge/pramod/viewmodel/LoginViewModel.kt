package com.pdge.pramod.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pdge.pramod.dash.Dashboard

class LoginViewModel:ViewModel() {
    private lateinit var context: Context
    val email = MutableLiveData<String>()
    val  password = MutableLiveData<String>()


        fun onLogin(){


            Log.e("email",email.toString())
        }
}