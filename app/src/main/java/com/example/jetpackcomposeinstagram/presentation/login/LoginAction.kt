package com.example.jetpackcomposeinstagram.presentation.login

sealed class LoginAction {
    object OnLoginAction : LoginAction()
    object ValidatorButtonLoginAction : LoginAction()
}