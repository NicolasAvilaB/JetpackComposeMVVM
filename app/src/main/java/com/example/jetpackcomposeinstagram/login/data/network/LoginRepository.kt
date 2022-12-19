package com.example.jetpackcomposeinstagram.login.data.network

import javax.inject.Inject

class LoginRepository @Inject constructor(private val api : LoginService){

    suspend fun doLogin(user:String, password:String) {
        return api.doLogin(user,password)
    }
}