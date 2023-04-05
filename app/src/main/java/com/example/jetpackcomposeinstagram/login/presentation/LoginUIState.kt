package com.example.jetpackcomposeinstagram.login.presentation

sealed class LoginUIState {
    object DefaultUiState : LoginUIState()
    object LoadingUiState : LoginUIState()
    object SuccessUiState : LoginUIState()
    data class ErrorUiState(val error: String): LoginUIState()
}