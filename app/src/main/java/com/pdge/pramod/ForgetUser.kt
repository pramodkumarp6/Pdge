package com.pdge.pramod

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.pdge.pramod.app.RetrofitClient
import com.pdge.pramod.databinding.ActivityForgetUserBinding
import com.pdge.pramod.model.ForgetPost
import com.pdge.pramod.model.ForgetUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgetUser : AppCompatActivity() {
    private lateinit var activityForgetUserBinding: ActivityForgetUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityForgetUserBinding = DataBindingUtil.setContentView(this,R.layout.activity_forget_user)
        title="Account Forget"


        activityForgetUserBinding.buttonLogin.setOnClickListener{
            forgetuser()
        }

    }

    private fun forgetuser() {
        val progressDialog = ProgressDialog(this@ForgetUser)
        val email = activityForgetUserBinding.editemail.text.toString().trim()

        if(email.isEmpty()){
            activityForgetUserBinding.editemail.error="Required Email"
            activityForgetUserBinding.editemail.requestFocus()
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