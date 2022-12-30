package com.example.jetpackcomposeinstagram.presentation.login

sealed class LoginUIntent {
    data class OnLoginUIntent(val users: String, val passw: String) : LoginUIntent()
}