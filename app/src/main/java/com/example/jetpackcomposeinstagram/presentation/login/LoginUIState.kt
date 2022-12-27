package com.example.jetpackcomposeinstagram.presentation.login

<<<<<<< HEAD
import com.example.jetpackcomposeinstagram.data.remote.models.Constants
import com.google.gson.annotations.SerializedName

sealed class LoginUIState {
    object Idle: LoginUIState()
    object Loading: LoginUIState()
    data class Success(@SerializedName(Constants.SUCCESS) val success: Boolean): LoginUIState()
    data class Error (val error: String?): LoginUIState()
=======
sealed class LoginUIState {
    object DefaultUiState : LoginUIState()
    object LoadingUiState: LoginUIState()
    object SuccessUiState: LoginUIState()
    object ErrorUiState: LoginUIState()
>>>>>>> develop
}