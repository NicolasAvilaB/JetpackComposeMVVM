package com.example.jetpackcomposeinstagram.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
<<<<<<< HEAD:app/src/main/java/com/example/jetpackcomposeinstagram/MainActivity.kt
import com.example.jetpackcomposeinstagram.ui.LoginScreen
=======
>>>>>>> develop:app/src/main/java/com/example/jetpackcomposeinstagram/ui/MainActivity.kt
import com.example.jetpackcomposeinstagram.presentation.login.LoginViewModel
import com.example.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

<<<<<<< HEAD:app/src/main/java/com/example/jetpackcomposeinstagram/MainActivity.kt
    private val loginViewModel: LoginViewModel by viewModels()
=======
    val loginViewModel: LoginViewModel by viewModels()
>>>>>>> develop:app/src/main/java/com/example/jetpackcomposeinstagram/ui/MainActivity.kt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen(loginViewModel)
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeInstagramTheme {
        LoginScreen(LoginViewModel())

    }
}*/
