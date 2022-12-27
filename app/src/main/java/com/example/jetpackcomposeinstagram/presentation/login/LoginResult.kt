package com.example.jetpackcomposeinstagram.presentation.login

<<<<<<< HEAD
internal sealed class LoginResult {
    sealed class FetchLoginResult:LoginResult(){
        object InProgress: FetchLoginResult()
        object Success: FetchLoginResult()
        object Error: FetchLoginResult()
=======
import com.example.jetpackcomposeinstagram.data.remote.RemoteLogin

sealed class LoginResult {
    sealed class OnLoginResult:LoginResult(){
        object InProgress: OnLoginResult()
        data class Success(val remotelogin: RemoteLogin): OnLoginResult()
        object Error: OnLoginResult()
>>>>>>> develop
    }
}