package com.example.jetpackcomposeinstagram.di

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.jetpackcomposeinstagram.data.LoginRepository
import com.example.jetpackcomposeinstagram.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
@ExperimentalAnimationApi
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun repository(): LoginRepository

    fun inject(activity: MainActivity)

    fun provideContext(): Context
}