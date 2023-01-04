package com.example.jetpackcomposeinstagram.di

import androidx.compose.animation.ExperimentalAnimationApi
import com.example.jetpackcomposeinstagram.ui.MainActivity
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@LoginScope
@Component(dependencies = [AppComponent::class])

interface LoginComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): LoginComponent
    }

    fun inject(activity: MainActivity)

}