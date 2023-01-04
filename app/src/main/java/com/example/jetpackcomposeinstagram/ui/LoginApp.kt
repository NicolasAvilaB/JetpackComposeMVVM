package com.example.jetpackcomposeinstagram.ui

import android.app.Application
import com.example.jetpackcomposeinstagram.di.AppComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
class LoginApp : Application() {

    /*val appComponent: AppComponent by lazy { initializeComponent() }
*/
    /*private fun initializeComponent(): AppComponent = DaggerLoginComponent
        .factory()
        .create(applicationContext)
*/
}