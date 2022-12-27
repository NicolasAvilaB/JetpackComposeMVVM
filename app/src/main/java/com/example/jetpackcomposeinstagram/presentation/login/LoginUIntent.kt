package com.example.jetpackcomposeinstagram.presentation.login

sealed class LoginUIntent {
    object OnLoginUIntent : LoginUIntent()
    object ValidatorButtonLoginUIntent : LoginUIntent()
}