package com.example.jetpackcomposeinstagram.presentation.login

import com.example.jetpackcomposeinstagram.data.remote.RemoteLogin

sealed class LoginResult {
    sealed class OnLoginResult:LoginResult(){
        object InProgress: OnLoginResult()
        data class Success(val remotelogin: RemoteLogin): OnLoginResult()
        object Error: OnLoginResult()
    }
}