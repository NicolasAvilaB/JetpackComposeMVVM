package com.example.jetpackcomposeinstagram.data

import com.example.jetpackcomposeinstagram.data.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient){
//    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String) {
        withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}