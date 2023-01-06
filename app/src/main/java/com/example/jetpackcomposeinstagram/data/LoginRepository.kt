package com.example.jetpackcomposeinstagram.data

import com.example.jetpackcomposeinstagram.data.remote.models.RemoteLogin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository @Inject constructor(val api : LoginService){

    fun doLogin(): Flow<RemoteLogin> = flow {
        val response = api.doLogin()
        emit(response as RemoteLogin)
    }
}