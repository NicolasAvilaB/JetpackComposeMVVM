package com.example.jetpackcomposeinstagram.presentation.login

sealed class LoginUIState {
    object DefaultUiState : LoginUIState()
    object LoadingUiState : LoginUIState()
    object SuccessUiState : LoginUIState()
    data class ErrorUiState(val error: String): LoginUIState()
}