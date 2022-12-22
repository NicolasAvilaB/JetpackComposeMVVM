package com.example.jetpackcomposeinstagram.presentation.login

import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult
import kotlinx.coroutines.flow.*

class LoginReducer {

    infix fun LoginUIState.reduceWith(result: LoginResult): LoginUIState {
        return when (val previousState = this) {
            is LoginUIState.Error -> TODO()
            LoginUIState.Inactive -> TODO()
            LoginUIState.Loading -> TODO()
            is LoginUIState.Success -> TODO()
        }
    }

    infix fun LoginUIState.reduceWith(result: LoginResult) =
        when (result) {

        }


}