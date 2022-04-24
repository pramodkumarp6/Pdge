package com.pdge.pramod

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pdge.consultancy.app.RetrofitClient
import com.pdge.consultancy.dash.Dashboard
import com.pdge.consultancy.model.LoginPost
import com.pdge.consultancy.model.LoginResponse


import retrofit2.Response

import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback


class LoginActivity : AppCompatActivity() {
  

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title="Login"


        buttonLogin.setOnClickListener{

            val progressDialog = ProgressDialog(this@LoginActivity)
            val email = editemail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            if(email.isEmpty()){
                editemail.error="Required Email"
                editemail.requestFocus()
                return@setOnClickListener

            }

            if(password.isEmpty()){
                editTextPassword.error="Required Pasword"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }
            progressDialog.setTitle("Login..")
            progressDialog.setMessage("loding")
            progressDialog.show()
            val intent = Intent(applicationContext,Dashboard::class.java)
            startActivity(intent)
            val  loginPost = LoginPost(email,password)

            RetrofitClient.instance.login(loginPost)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {


                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        progressDialog.hide()
                        Toast.makeText(applicationContext,response.body()?.message ,Toast.LENGTH_LONG).show();

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




        textViewRegister2.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }




        textViewRegister1.setOnClickListener {
            startActivity(Intent(this@LoginActivity, com.pdge.pramod.ForgetUser::class.java))
        }



    }

}








