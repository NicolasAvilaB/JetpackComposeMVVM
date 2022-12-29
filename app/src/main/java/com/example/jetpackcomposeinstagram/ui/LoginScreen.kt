package com.example.jetpackcomposeinstagram.ui

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState
import com.example.jetpackcomposeinstagram.presentation.login.LoginViewModel

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
fun LoadingComponent() {
    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
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
    when (uiState.value) {
        LoginUIState.ErrorUiState -> println("Error Uistate, se fue a las pailas")
        LoginUIState.DefaultUiState -> {
            println("Default Uistate")
            DisplayLoginComponent(loginIntentHandler)
        }
        LoginUIState.LoadingUiState -> {
            println("Loading Uistate")
            LoadingComponent()
        }
        LoginUIState.SuccessUiState -> {
            DisplayLoginComponent(loginIntentHandler)
            println("Success Uistate")
            println(LoginUIState.SuccessUiState)
        }
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SignUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Don't have an account?", fontSize = 12.sp, color = Color(0xFFB5B5B5)
        )
        Text(
            text = "Sign up.",
            Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
        )
    }
}

@Composable
fun Body(modifier: Modifier, loginIntentHandler: LoginIntentHandler) {
    /*val email:String by LoginIntentHandler.email.observeAsState(initial = "")
    val password:String by LoginIntentHandler.password.observeAsState(initial = "")*/

    Column(modifier = modifier) {
        Saludo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))



        LoginButton(loginIntentHandler)
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Composable
fun LoginButton(loginIntentHandler: LoginIntentHandler) {
    Button(
        onClick = { loginIntentHandler.pressButtonLogin() },
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
        modifier = Modifier.fillMaxWidth(),
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
