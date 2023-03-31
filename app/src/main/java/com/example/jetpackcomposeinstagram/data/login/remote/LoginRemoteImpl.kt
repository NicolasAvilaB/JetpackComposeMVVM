package com.example.jetpackcomposeinstagram.data.login.remote

import com.example.jetpackcomposeinstagram.data.Retrofit
import com.example.jetpackcomposeinstagram.data.login.remote.retrofit.LoginWebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRemoteImpl {
    private val retrofit = Retrofit()

    suspend fun doLogin():Any {
        return withContext(Dispatchers.IO){
           retrofit.getRetrofit().create(LoginWebService::class.java).doLogin()
        }
    }

}