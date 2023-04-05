package com.example.jetpackcomposeinstagram.login.data

import com.example.jetpackcomposeinstagram.login.data.remote.LoginRemoteImpl
import com.example.jetpackcomposeinstagram.login.data.remote.model.RemoteLogin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepository {

    private val api = LoginRemoteImpl()

    fun doLogin(): Flow<RemoteLogin> = flow {
        val response = api.doLogin()
        emit(response as RemoteLogin)
    }
}