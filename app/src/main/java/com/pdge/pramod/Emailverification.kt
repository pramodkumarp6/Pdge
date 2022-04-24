package com.pdge.pramod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pdge.pramod.databinding.ActivityEmailverificationBinding

class Emailverification : AppCompatActivity() {
    private lateinit var activityEmailverificationBinding: ActivityEmailverificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityEmailverificationBinding = DataBindingUtil. setContentView(this,R.layout.activity_emailverification)
    }
}