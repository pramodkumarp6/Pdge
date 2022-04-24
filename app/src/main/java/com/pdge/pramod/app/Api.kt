package com.pdge.pramod.app

import com.pdge.pramod.model.*
import com.pdge.pramod.repository.UserResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*


interface Api {
    @Headers("Content-Type: application/json")
    @POST("/api/register")
    fun userRegister(@Body users: RegisterPost): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("/api/login")
    fun  login(@Body users: LoginPost): Call<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/userForget")
    fun forgetUser(@Body forpost: ForgetPost): Call<ForgetUserResponse>

    @GET("/simple/public/allusers")
    fun userData(): Observable<UserResponse?>?



}