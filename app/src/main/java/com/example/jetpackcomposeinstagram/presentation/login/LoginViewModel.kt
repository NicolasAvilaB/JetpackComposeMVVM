package com.example.jetpackcomposeinstagram.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeinstagram.presentation.login.LoginAction.OnLoginAction
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.DefaultUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIntent.OnLoginUIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LoginViewModel : ViewModel() {
    private val reducer = LoginReducer()
    private val processor = LoginProcessor()

    fun loginuiState(): StateFlow<LoginUIState> = loginuiState
    val loginDefaultUiState: LoginUIState = DefaultUiState
    private val loginuiState: MutableStateFlow<LoginUIState> = MutableStateFlow(loginDefaultUiState)

    fun processUserIntentsAndObserveUiStates(
        loginIntents: Flow<LoginUIntent>,
        coroutineScope: CoroutineScope = viewModelScope,
    ) {
        loginIntents.buffer()
            .flatMapMerge { loginIntent ->
                processor.actionProcessor(loginIntent.toAction())
            }
            .scan(loginDefaultUiState) { previousUiState, result ->
                with(reducer) { previousUiState reduceWith result }
            }
            .onEach { loginstate ->
                loginuiState.value = loginstate
            }
            .launchIn(coroutineScope)
    }

    private fun LoginUIntent.toAction(): LoginAction {
        return when (this) {
            OnLoginUIntent -> OnLoginAction
        }
    }
}