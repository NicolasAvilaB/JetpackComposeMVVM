package com.example.jetpackcomposeinstagram.ui

import com.example.jetpackcomposeinstagram.presentation.login.LoginUIntent
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIntent.OnLoginUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginIntentHandler {

    val loginsIntents = MutableSharedFlow<LoginUIntent>()
    var coroutineScope: CoroutineScope? = null

    internal fun loginIntents(): Flow<LoginUIntent> = loginsIntents.asSharedFlow()

    fun pressButtonLogin(users: String, passw: String) {
        coroutineScope?.launch {
            loginsIntents.emit(OnLoginUIntent(users,passw))
        }
    }

}