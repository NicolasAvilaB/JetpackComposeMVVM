package com.example.jetpackcomposeinstagram.presentation.login

sealed class LoginUIState {
    object Inactive : LoginUIState()
    object Loading: LoginUIState()
    object Success: LoginUIState()
    object Error: LoginUIState()
}