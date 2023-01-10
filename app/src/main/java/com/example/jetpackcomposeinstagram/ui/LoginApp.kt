package com.example.jetpackcomposeinstagram.ui

import android.app.Application
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.jetpackcomposeinstagram.di.AppComponent
import com.example.jetpackcomposeinstagram.di.DaggerAppComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
@ExperimentalAnimationApi
class LoginApp : Application() {

    val appComponent: AppComponent by lazy { initializeComponent() }
    private fun initializeComponent(): AppComponent = DaggerAppComponent
        .factory()
        .create(applicationContext)
}