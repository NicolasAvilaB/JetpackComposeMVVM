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
            OnLoginAction -> onLoginProcessor()
        }

    private fun onLoginProcessor(): Flow<OnLoginResult> =
        repository.doLogin()
            .map { remoteLogin ->
                if (remoteLogin.user != "goku" && remoteLogin.password != "sayain") {
                    Error
                } else {
                    Success(remoteLogin) as OnLoginResult
                }
            }
            .onStart {
                emit(InProgress)
            }
            .catch {
                emit(Error)
            }
            .flowOn(Dispatchers.IO)
}