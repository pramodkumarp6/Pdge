package com.pdge.consultancy

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pdge.consultancy.app.RetrofitClient
import com.pdge.consultancy.model.ForgetPost
import com.pdge.consultancy.model.ForgetUserResponse
import com.pdge.consultancy.model.LoginPost
import com.pdge.consultancy.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgetUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_user)
        title="Account Forget"


        buttonLogin.setOnClickListener{
            forgetuser()
        }

    }

    private fun forgetuser() {
        val progressDialog = ProgressDialog(this@ForgetUser)
        val email = editemail.text.toString().trim()

        if(email.isEmpty()){
            editemail.error="Required Email"
            editemail.requestFocus()
            return

        }


        progressDialog.setTitle("Login..")
        progressDialog.setMessage("loding")
        progressDialog.show()

        val  forpost = ForgetPost(email)
        RetrofitClient.instance.forgetUser(forpost)
            .enqueue(object : Callback<ForgetUserResponse> {
                override fun onFailure(call: Call<ForgetUserResponse>, t: Throwable) {


                }

                override fun onResponse(call: Call<ForgetUserResponse>, response: Response<ForgetUserResponse>) {
                    progressDialog.hide()
                    Toast.makeText(applicationContext,response.body()?.message , Toast.LENGTH_LONG).show();



                }

            })


    }
}