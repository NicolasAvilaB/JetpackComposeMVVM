package com.example.jetpackcomposeinstagram.ui

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.ErrorUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.DefaultUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.SuccessUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState.LoadingUiState
import com.example.jetpackcomposeinstagram.presentation.login.LoginViewModel
import com.example.jetpackcomposeinstagram.ui.login.components.MessageDialog
import com.example.jetpackcomposeinstagram.ui.login.LoadingComponent
import com.example.jetpackcomposeinstagram.ui.login.Spacers
import com.example.jetpackcomposeinstagram.R.string
import com.example.jetpackcomposeinstagram.ui.login.ui.LoginIntentHandler
import com.example.jetpackcomposeinstagram.ui.theme.background_textfield_login
import com.example.jetpackcomposeinstagram.ui.theme.Purple500
import com.example.jetpackcomposeinstagram.ui.theme.colorText_textfield_login
import com.example.jetpackcomposeinstagram.ui.theme.background_button_login
import com.example.jetpackcomposeinstagram.ui.theme.disabled_button_login


@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    val loginIntentHandler = LoginIntentHandler().apply {
        coroutineScope = rememberCoroutineScope()
    }
    loginViewModel.processUserIntentsAndObserveUiStates(loginIntentHandler.loginIntents())
    val uiState =
        remember { loginViewModel.loginuiState() }.collectAsState(initial = loginViewModel.loginDefaultUiState)
    LoginContent(loginIntentHandler, uiState)

}

@Composable
fun DisplayLoginComponent(loginIntentHandler: LoginIntentHandler) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), loginIntentHandler)
    }
}

@Composable
fun LoginContent(loginIntentHandler: LoginIntentHandler, uiState: State<LoginUIState>) {
    val saludo : String = stringResource(id = string.bienvenido)
    val default_uistate : String = stringResource(id = string.defaultuistate)
    val success_uistate : String = stringResource(id = string.successuistate)
    val loading_uistate : String = stringResource(id = string.loadinguistate)
    when (val value = uiState.value) {
        is ErrorUiState -> {
            DisplayLoginComponent(loginIntentHandler)
            var show by rememberSaveable { mutableStateOf(true) }
            MessageDialog(show=show, onDismiss = {show = false}, text = value.error)
        }
        is DefaultUiState -> {
            println(default_uistate)
            DisplayLoginComponent(loginIntentHandler)
        }
        is LoadingUiState -> {
            println(loading_uistate)
            LoadingComponent()
        }
        is SuccessUiState -> {
            println(success_uistate)
            var show by rememberSaveable { mutableStateOf(true) }
            MessageDialog(show=show, onDismiss = {show = false}, text = saludo)
        }
    }
}

@Composable
fun Body(modifier: Modifier, loginIntentHandler: LoginIntentHandler) {
    var users by rememberSaveable { mutableStateOf("")}
    var passw by rememberSaveable { mutableStateOf("")}
    Column(modifier = modifier) {
        Saludo(Modifier.align(Alignment.CenterHorizontally))
        Spacers(8.dp)
        ForgotPassword(Modifier.align(Alignment.End))
        Spacers(16.dp)
        Email(users){
            users = it
        }
        Spacers(8.dp)
        Password(passw){
            passw = it
        }
        Spacers(16.dp)
        LoginButton(loginIntentHandler, users, passw)
        Spacers(16.dp)
    }
}

@Composable
fun LoginButton(loginIntentHandler: LoginIntentHandler, users: String, passw: String) {
    val LogIn : String = stringResource(id = string.login)
    Button(
        onClick = { loginIntentHandler.pressButtonLogin(users, passw) },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(background_button_login.value),
            disabledBackgroundColor = Color(disabled_button_login.value),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = LogIn)
    }
}


@Composable
fun ForgotPassword(modifier: Modifier) {
    val forgotpassword : String = stringResource(id = string.forgotpassword)
    Text(
        text = forgotpassword,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(Purple500.value),
        modifier = modifier
    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    val showpassword : String = stringResource(id = string.showpass)
    val passwordt : String = stringResource(id = string.password)
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(passwordt) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(colorText_textfield_login.value),
            backgroundColor = Color(background_textfield_login.value),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = imagen, contentDescription = showpassword)
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    val email_s : String = stringResource(id = string.email_s)
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .clipToBounds(),
        placeholder = { Text(text = email_s) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(colorText_textfield_login.value),
            backgroundColor = Color(background_textfield_login.value),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Saludo(modifier: Modifier) {
    val saludo : String = stringResource(id = string.saludo)
    Text(text = saludo, modifier = modifier, fontWeight = FontWeight.Bold, fontSize = 28.sp)
}

@Composable
fun Header(modifier: Modifier) {
    val closeapps : String = stringResource(id = string.closeapp)
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = closeapps,
        modifier = modifier.clickable { activity.finish() })
}
