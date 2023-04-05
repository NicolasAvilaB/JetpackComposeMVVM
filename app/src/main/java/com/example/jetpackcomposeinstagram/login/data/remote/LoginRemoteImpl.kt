package com.example.jetpackcomposeinstagram.login.data.remote

import com.example.jetpackcomposeinstagram.login.data.Retrofit
import com.example.jetpackcomposeinstagram.login.data.remote.retrofit.LoginWebService
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