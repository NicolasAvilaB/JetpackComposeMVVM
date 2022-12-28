package com.example.jetpackcomposeinstagram.domain

import com.example.jetpackcomposeinstagram.data.LoginRepository
import com.example.jetpackcomposeinstagram.data.remote.models.RemoteLogin
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    operator fun invoke(user: String, password: String): Flow<RemoteLogin> {
        return repository.doLogin()
    }
}