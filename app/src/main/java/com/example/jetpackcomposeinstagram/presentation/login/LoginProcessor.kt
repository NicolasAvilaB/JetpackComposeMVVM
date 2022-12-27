package com.example.jetpackcomposeinstagram.presentation.login

<<<<<<< HEAD
class LoginProcessor {
=======
import android.util.Log
import com.example.jetpackcomposeinstagram.data.LoginRepository
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.Success
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.Error
import com.example.jetpackcomposeinstagram.presentation.login.LoginResult.OnLoginResult.InProgress
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class LoginProcessor {

    private val repository = LoginRepository()

    fun actionProcessor(actions: LoginAction): Flow<OnLoginResult> =
        when (actions) {
            LoginAction.OnLoginAction -> onLoginProcessor()
        }

    private fun onLoginProcessor(): Flow<OnLoginResult> =
        repository.doLogin("", "")
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
>>>>>>> develop
}