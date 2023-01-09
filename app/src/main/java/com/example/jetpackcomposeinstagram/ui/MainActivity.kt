package com.example.jetpackcomposeinstagram.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.jetpackcomposeinstagram.di.DaggerLoginComponent
import com.example.jetpackcomposeinstagram.di.LoginComponent
import com.example.jetpackcomposeinstagram.presentation.login.LoginViewModel
import com.example.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    @Inject lateinit var loginViewModel: LoginViewModel

    val loginComponent: LoginComponent by lazy {
        initializeMainComponent()
    }

    fun initializeMainComponent(): LoginComponent {
        val applicationComponent = (applicationContext as LoginApp).appComponent
        return DaggerLoginComponent.factory().create(applicationComponent)
    }



    //val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as LoginApp).appComponent.inject(this)

        setContent {
            JetpackComposeInstagramTheme {
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