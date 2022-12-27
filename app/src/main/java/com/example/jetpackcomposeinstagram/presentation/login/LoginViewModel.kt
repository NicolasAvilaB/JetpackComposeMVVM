package com.example.jetpackcomposeinstagram.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LoginViewModel : ViewModel() {

    private val reducer = LoginReducer()
    private val processor= LoginProcessor()

    fun loginuiState(): StateFlow<LoginUIState> = loginuiState
    val loginInactiveUiState: LoginUIState = LoginUIState.DefaultUiState
    private val loginuiState: MutableStateFlow<LoginUIState> = MutableStateFlow(loginInactiveUiState)

    fun processUserIntentsAndObserveUiStates(
        loginIntents: Flow<LoginUIntent>,
        coroutineScope: CoroutineScope = viewModelScope,
    ) {
        loginIntents.buffer()
            .flatMapMerge { loginIntent ->
                processor.actionProcessor(loginIntent.toAction())
            }
            .scan(loginInactiveUiState) { previousUiState, result ->
                with(reducer) { previousUiState reduceWith result }
            }
            .onEach {
                loginuiState.value = it
            }
            .launchIn(coroutineScope)
    }

    private fun LoginUIntent.toAction(): LoginAction {
        return when (this) {
            LoginUIntent.OnLoginUIntent -> LoginAction.OnLoginAction
        }
    }
}