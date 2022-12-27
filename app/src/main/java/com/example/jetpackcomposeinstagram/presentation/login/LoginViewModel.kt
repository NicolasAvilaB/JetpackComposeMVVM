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
            LoginUIntent.ValidatorButtonLoginUIntent -> LoginAction.ValidatorButtonLoginAction
        }
    }


    /*private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    //    en el processor, intent a action
    fun onLogin() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value.orEmpty(), password.value.orEmpty())
            when (result) {
                result -> Log.i(email.value.orEmpty(), password.value.orEmpty())
            }
            _isLoading.value = false
        }
    }

    fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6*/
}