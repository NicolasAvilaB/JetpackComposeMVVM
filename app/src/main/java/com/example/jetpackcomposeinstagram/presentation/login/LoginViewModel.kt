package com.example.jetpackcomposeinstagram.presentation.login

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeinstagram.presentation.login.LoginAction.OnLoginAction
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.DefaultUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIntent.OnLoginUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
@ExperimentalAnimationApi
class LoginViewModel @Inject constructor(
    val reducer: LoginReducer,
    val processor: LoginProcessor
) : ViewModel() {

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
            is OnLoginUIntent -> OnLoginAction(this.users, this.passw)
        }
    }
}