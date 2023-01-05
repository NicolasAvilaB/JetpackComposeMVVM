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
    when (val value = uiState.value) {
        is ErrorUiState -> {
            DisplayLoginComponent(loginIntentHandler)
            var show by rememberSaveable { mutableStateOf(true) }
            MessageDialog(show=show, onDismiss = {show = false}, text = value.error)
        }
        is DefaultUiState -> {
            println("Default Uistate")
            DisplayLoginComponent(loginIntentHandler)
        }
        is LoadingUiState -> {
            println("Loading Uistate")
            LoadingComponent()
        }
        is SuccessUiState -> {
            println("Success Uistate")
            var show by rememberSaveable { mutableStateOf(true) }
            MessageDialog(show=show, onDismiss = {show = false}, text = "Bienvenido !!")
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
    Button(
        onClick = { loginIntentHandler.pressButtonLogin(users, passw) },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EA8E9),
            disabledBackgroundColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log In")
    }
}


@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Password") },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
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
                Icon(imageVector = imagen, contentDescription = "show password")
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
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth().clipToBounds(),
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Saludo(modifier: Modifier) {
    Text(text = "Hola!", modifier = modifier, fontWeight = FontWeight.Bold, fontSize = 28.sp)
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close app",
        modifier = modifier.clickable { activity.finish() })
}
