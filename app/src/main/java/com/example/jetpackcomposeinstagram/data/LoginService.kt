package com.example.jetpackcomposeinstagram.data

import com.example.jetpackcomposeinstagram.data.remote.RemoteLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    //private val loginClient: LoginClient()

    //fun doLogin(user: String, password: String): RemoteLogin = loginClient.doLogin()

    suspend fun doLogin(user: String, password: String):Any {
        return withContext(Dispatchers.IO){
           retrofit.create(LoginClient::class.java).doLogin()
        }
    }

}