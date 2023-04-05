package com.example.jetpackcomposeinstagram.login.presentation

sealed class LoginAction {
    data class OnLoginAction(val users: String, val passw: String) : LoginAction()
}