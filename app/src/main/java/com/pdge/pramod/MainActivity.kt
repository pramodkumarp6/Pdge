package com.pdge.pramod

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.pdge.pramod.app.RetrofitClient
import com.pdge.pramod.databinding.ActivityMainBinding
import com.pdge.pramod.model.DefaultResponse
import com.pdge.pramod.model.RegisterPost

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        title="Register"

        activityMainBinding.buttonRegiter.setOnClickListener{
            register()
        }

    }

    private fun register() {
        val progressDialog = ProgressDialog(this@MainActivity)
        val first_name = activityMainBinding. editname.text.toString().trim()
        val last_name = activityMainBinding.editlast.text.toString().trim()
        val gender = activityMainBinding.editgender.text.toString().trim()
        val email = activityMainBinding.editemail.text.toString().trim()
        val password = activityMainBinding.editPassword.text.toString().trim()
        val number = activityMainBinding.editnumber.text.toString().trim()
        val address = activityMainBinding.editaddress.text.toString().trim()
        if (first_name.isEmpty()) {
            activityMainBinding.editname.error = "First Name is Requied"
            activityMainBinding.editname.requestFocus()
            return

        }

        if (password.isEmpty()) {
            activityMainBinding.editPassword.error = "Password is Required"
            activityMainBinding.editPassword.requestFocus()
            return
        }

        if (email.isEmpty()) {
            activityMainBinding.editemail.error = "Email is Reqiued "
            activityMainBinding. editemail.requestFocus()
            return
        }

        if (gender.isEmpty()) {
            activityMainBinding.editgender.error = "Gender is Required"
            activityMainBinding.editgender.requestFocus()
            return
        }
        if (number.isEmpty()) {
            activityMainBinding.editnumber.error = " Mobile Number Required"
            activityMainBinding.editnumber.requestFocus()
            return
        }
        if (address.isEmpty()) {
            activityMainBinding.editaddress.error = "Address is Required"
            activityMainBinding.editaddress.requestFocus()
            return
        }
            progressDialog.setTitle("Login..")
        progressDialog.setMessage("loding")
        progressDialog.show()
               val registerPost = RegisterPost(first_name,last_name,gender,email,password,number,address)
        RetrofitClient.instance.userRegister(registerPost)
            .enqueue(object: Callback<DefaultResponse> {

                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {

                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                    progressDialog.hide()
                    Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                }

            })


    }
}