package com.example.jetpackcomposeinstagram.data.login

import com.example.jetpackcomposeinstagram.data.login.remote.LoginRemoteImpl
import com.example.jetpackcomposeinstagram.data.login.remote.model.RemoteLogin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepository {

    private val api = LoginRemoteImpl()

    fun doLogin(): Flow<RemoteLogin> = flow {
        val response = api.doLogin()
        emit(response as RemoteLogin)
    }
}