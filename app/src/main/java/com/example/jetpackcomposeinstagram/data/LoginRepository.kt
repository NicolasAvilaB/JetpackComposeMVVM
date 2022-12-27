package com.example.jetpackcomposeinstagram.data

import com.example.jetpackcomposeinstagram.data.remote.RemoteLogin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository {

    private val api = LoginService()

    fun doLogin(user:String, password:String): Flow<RemoteLogin> = flow {
        val response = api.doLogin(user,password)
        emit(response as RemoteLogin)
    }
}