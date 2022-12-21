package com.example.jetpackcomposeinstagram.presentation.login

internal sealed class LoginResult {
    sealed class FetchLoginResult:LoginResult(){
        object InProgress: FetchLoginResult()
        object Success: FetchLoginResult()
        object Error: FetchLoginResult()
    }
}