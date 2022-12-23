package com.example.jetpackcomposeinstagram.presentation.login

sealed class LoginUIState {
    object InactiveUiState : LoginUIState()
    object LoadingUiState: LoginUIState()
    object SuccessUiState: LoginUIState()
    object ErrorUiState: LoginUIState()
}