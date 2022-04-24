package com.pdge.pramod

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pdge.consultancy.app.RetrofitClient
import com.pdge.consultancy.model.DefaultResponse
import com.pdge.consultancy.model.RegisterPost

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.editemail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Register"

        buttonRegiter.setOnClickListener{
            register()
        }

    }

    private fun register() {
        val progressDialog = ProgressDialog(this@MainActivity)
        val first_name = editname.text.toString().trim()
        val last_name = editlast.text.toString().trim()
        val gender = editgender.text.toString().trim()
        val email = editemail.text.toString().trim()
        val password = editPassword.text.toString().trim()
        val number = editnumber.text.toString().trim()
        val address = editaddress.text.toString().trim()
        if (first_name.isEmpty()) {
            editname.error = "First Name is Requied"
            editname.requestFocus()
            return

        }

        if (password.isEmpty()) {
            editPassword.error = "Password is Required"
            editPassword.requestFocus()
            return
        }

        if (email.isEmpty()) {
            editemail.error = "Email is Reqiued "
            editemail.requestFocus()
            return
        }

        if (gender.isEmpty()) {
            editgender.error = "Gender is Required"
            editgender.requestFocus()
            return
        }
        if (number.isEmpty()) {
            editnumber.error = " Mobile Number Required"
            editnumber.requestFocus()
            return
        }
        if (address.isEmpty()) {
            editaddress.error = "Address is Required"
            editaddress.requestFocus()
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