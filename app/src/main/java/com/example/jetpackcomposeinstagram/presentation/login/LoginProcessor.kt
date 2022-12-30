package com.example.jetpackcomposeinstagram.presentation.login

import com.example.jetpackcomposeinstagram.data.LoginRepository
import com.example.jetpackcomposeinstagram.presentation.login.LoginAction.OnLoginAction
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class LoginProcessor {

    private val repository = LoginRepository()
    fun actionProcessor(actions: LoginAction): Flow<OnLoginResult> =
        when (actions) {
            is OnLoginAction -> onLoginProcessor(actions.users, actions.passw)
        }

    private fun onLoginProcessor(users: String, passw: String): Flow<OnLoginResult> =
        repository.doLogin()
            .map { remoteLogin ->
                if (remoteLogin.user != users && remoteLogin.password != passw) {
                    IncorrectCredentials(INCORRECT_CREDENTIALS)
                } else {
                    Success(remoteLogin) as OnLoginResult
                }
            }
            .onStart {
                emit(InProgress)
            }
            .catch {
                emit(Error(ERROR_CONNECTION))
            }
            .flowOn(Dispatchers.IO)

    companion object {
        const val INCORRECT_CREDENTIALS = "Las credenciales son Incorrectas"
        const val ERROR_CONNECTION = "Error: no ha sido posible conectarse"
    }
}