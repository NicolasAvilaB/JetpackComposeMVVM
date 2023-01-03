package com.example.jetpackcomposeinstagram.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin():Any {
        return withContext(Dispatchers.IO){
           retrofit.create(LoginClient::class.java).doLogin()
        }
    }

}