package com.example.jetpackcomposeinstagram.presentation.login

import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.ErrorUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.DefaultUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.LoadingUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.SuccessUiState

class LoginReducer {

    private fun unsupportedReduceCase() = RuntimeException()

    infix fun LoginUIState.reduceWith(result: LoginResult): LoginUIState {
        return when (val previousState = this) {
            is ErrorUiState -> previousState reduceWith result
            is DefaultUiState -> previousState reduceWith result
            is LoadingUiState -> previousState reduceWith result
            is SuccessUiState -> previousState reduceWith result
        }
    }

    infix fun LoadingUiState.reduceWith(result: LoginResult) = when (result){
        is OnLoginResult.Error -> ErrorUiState(result.error)
        is OnLoginResult.Success -> SuccessUiState
        is OnLoginResult.InProgress -> LoadingUiState
        is OnLoginResult.IncorrectCredentials -> ErrorUiState(result.message)
        else -> throw unsupportedReduceCase()
    }

    private infix fun SuccessUiState.reduceWith(result: LoginResult) = when (result) {
        is OnLoginResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun ErrorUiState.reduceWith(result: LoginResult) = when (result) {
        is OnLoginResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun DefaultUiState.reduceWith(result: LoginResult) = when (result) {
        is OnLoginResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

}