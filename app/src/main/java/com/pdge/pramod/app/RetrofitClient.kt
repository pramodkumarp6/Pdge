package com.pdge.pramod.app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // private val Auth = "Basic " + Base64.encodeToString("user:123456".toByteArray(), Base64.NO_WRAP)
    //private val AUTH = "Basic "+ Base64.encodeToString("belalkhan:123456".toByteArray(), Base64.NO_WRAP)
    public const val  BASE_URl="https://pramodkumarp6.pythonanywhere.com"
    /* private val okHttpClient =OkHttpClient.Builder()
         .addInterceptor{chain ->
             val original =chain.request()
             val requestBuilder = original.newBuilder()
                 .addHeader("Authentication", Auth)

                 .method(original.method(), original.body())
             val request = requestBuilder.build()
             chain.proceed(request)


         }.build()
 */
    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            // .client(okHttpClient)
            .build()
        retrofit.create(Api::class.java)
    }
}