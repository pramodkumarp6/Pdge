package com.pdge.pramod

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.pdge.pramod.app.RetrofitClient
import com.pdge.pramod.dash.Dashboard
import com.pdge.pramod.databinding.ActivityLoginBinding
import com.pdge.pramod.model.LoginPost
import com.pdge.pramod.model.LoginResponse
import com.pdge.pramod.viewmodel.LoginViewModel


import retrofit2.Response

import retrofit2.Call
import retrofit2.Callback

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    private lateinit var activityLoginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        title = "Login"


        activityLoginBinding.buttonLogin.setOnClickListener {

            val progressDialog = ProgressDialog(this@LoginActivity)
            val email = activityLoginBinding.editemail.text.toString().trim()
            val password = activityLoginBinding.editTextPassword.text.toString().trim()
            if (email.isEmpty()) {
                activityLoginBinding.editemail.error = "Required Email"
                activityLoginBinding.editemail.requestFocus()
                return@setOnClickListener

            }

            if (password.isEmpty()) {
                activityLoginBinding.editTextPassword.error = "Required Pasword"
                activityLoginBinding.editTextPassword.requestFocus()
                return@setOnClickListener
            }
            progressDialog.setTitle("Login..")
            progressDialog.setMessage("loding")
            progressDialog.show()
            val intent = Intent(applicationContext, Dashboard::class.java)
            startActivity(intent)
            val loginPost = LoginPost(email, password)

            RetrofitClient.instance.login(loginPost)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {


                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        progressDialog.hide()
                        Toast.makeText(
                            applicationContext,
                            response.body()?.message,
                            Toast.LENGTH_LONG
                        ).show()

                        /* if(!response.body()?.error!!){
                            // val intent = Intent(applicationContext,ProfileActivity::class.java)
                             intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                             startActivity(intent)

                         }else{
                             Toast.makeText(applicationContext,response.body()?.message ,Toast.LENGTH_LONG).show();
                         }*/

                    }

                })


        }




        activityLoginBinding.textViewRegister2.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }




        activityLoginBinding.textViewRegister1.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgetUser::class.java))
        }


    }

}








