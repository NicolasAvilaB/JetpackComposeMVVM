package com.example.jetpackcomposeinstagram.presentation.login

sealed class LoginAction {
    data class OnLoginAction(val users: String, val passw: String) : LoginAction()
}