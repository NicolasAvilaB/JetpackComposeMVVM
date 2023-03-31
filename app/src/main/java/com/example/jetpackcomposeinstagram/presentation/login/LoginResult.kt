package com.example.jetpackcomposeinstagram.presentation.login

import com.example.jetpackcomposeinstagram.data.login.remote.model.RemoteLogin

sealed class LoginResult {
    sealed class OnLoginResult:LoginResult(){
        object InProgress: OnLoginResult()
        data class Success(val remotelogin: RemoteLogin): OnLoginResult()
        data class Error(val error: String): OnLoginResult()
        data class IncorrectCredentials(val message: String): OnLoginResult()
        data class EmptyValues(val emptyvalue: String): OnLoginResult()
    }
}