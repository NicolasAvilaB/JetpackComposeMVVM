package com.example.jetpackcomposeinstagram.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(val retrofit : RetrofitHelper.getRetrofit){

    suspend fun doLogin():Any {
        return withContext(Dispatchers.IO){
           retrofit.create(LoginClient::class.java).doLogin()
        }
    }

}