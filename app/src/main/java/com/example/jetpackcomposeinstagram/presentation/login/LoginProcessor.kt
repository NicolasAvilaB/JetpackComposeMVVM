package com.example.jetpackcomposeinstagram.presentation.login

import com.example.jetpackcomposeinstagram.data.LoginRepository
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.Success
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.Error
import com.example.jetpackcomposeinstagram.presentation.login.LoginAction.OnLoginAction
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.InProgress
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class LoginProcessor {

    private val repository = LoginRepository()
    fun actionProcessor(actions: LoginAction): Flow<OnLoginResult> =
        when (actions) {
            OnLoginAction -> onLoginProcessor()
        }

    private fun onLoginProcessor(): Flow<OnLoginResult> =
        repository.doLogin()
            .map { remoteLogin ->
                Success(remoteLogin) as OnLoginResult
            }
            .onStart {
                emit(InProgress)
            }
            .catch {
                emit(Error)
            }
            .flowOn(Dispatchers.IO)
}