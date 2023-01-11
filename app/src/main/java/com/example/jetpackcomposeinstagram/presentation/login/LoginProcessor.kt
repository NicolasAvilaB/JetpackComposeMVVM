package com.example.jetpackcomposeinstagram.presentation.login

import com.example.jetpackcomposeinstagram.data.LoginRepository
import com.example.jetpackcomposeinstagram.presentation.DispatchProvider
import com.example.jetpackcomposeinstagram.presentation.login.LoginAction.OnLoginAction
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.EmptyValues
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.InProgress
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.Success
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.IncorrectCredentials
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginProcessor @Inject constructor(
    val repository : LoginRepository,
    val coroutineDispatchProvider: DispatchProvider
){

    fun actionProcessor(actions: LoginAction): Flow<OnLoginResult> =
        when (actions) {
            is OnLoginAction -> onLoginProcessor(actions.users, actions.passw)
        }

    private fun onLoginProcessor(users: String, passw: String): Flow<OnLoginResult> =
        repository.doLogin()
            .map { remoteLogin ->
                if(users.length == 0 && passw.length == 0) {
                    EmptyValues(EMPTY_VALUE)
                }else if (remoteLogin.user != users && remoteLogin.password != passw) {
                    IncorrectCredentials(INCORRECT_CREDENTIALS)
                }else {
                    Success(remoteLogin)
                }
            }
            .onStart {
                emit(InProgress)
            }
            .catch {
                emit(Error(ERROR_CONNECTION))
            }
            .flowOn(coroutineDispatchProvider.ioDispatch())

    companion object {
        const val INCORRECT_CREDENTIALS = "Las credenciales son Incorrectas"
        const val EMPTY_VALUE = "No ha ingresado nada"
        const val ERROR_CONNECTION = "Error: no ha sido posible conectarse, no es computable"
    }
}