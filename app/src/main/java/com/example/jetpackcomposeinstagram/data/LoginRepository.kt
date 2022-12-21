package com.example.jetpackcomposeinstagram.data

import javax.inject.Inject

class LoginRepository @Inject constructor(private val api : LoginService){

    suspend fun doLogin(user:String, password:String) {
        return api.doLogin(user,password)
    }
}