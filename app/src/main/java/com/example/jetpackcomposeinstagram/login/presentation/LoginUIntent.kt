package com.example.jetpackcomposeinstagram.login.presentation

sealed class LoginUIntent {
    data class OnLoginUIntent(val users: String, val passw: String) : LoginUIntent()
}