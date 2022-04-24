package com.pdge.pramod.dash.ui.slideshow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.pdge.pramod.app.RetrofitClient
import com.pdge.pramod.repository.UserResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserDetailsRepository {
    private val data = MutableLiveData<UserResponse>()
    fun userDetails(): MutableLiveData<UserResponse> {
        val observable: Observable<UserResponse?>? = RetrofitClient.instance.userData()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

        observable?.subscribe(object : Observer<UserResponse?> {
            override fun onSubscribe(d: Disposable) {
                TODO("Not yet implemented")
            }

            override fun onNext(userResponse: UserResponse) {
                data.setValue(userResponse)
                val gson = GsonBuilder().setPrettyPrinting().create()
                Log.e("MainActivity", gson.toJson(userResponse))
            }

            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                TODO("Not yet implemented")
            }

        })
        return data

    }
}