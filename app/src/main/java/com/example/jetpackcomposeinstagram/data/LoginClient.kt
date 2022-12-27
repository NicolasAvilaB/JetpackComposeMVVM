package com.example.jetpackcomposeinstagram.data

<<<<<<< HEAD
import com.example.jetpackcomposeinstagram.presentation.login.LoginUIState
=======
import com.example.jetpackcomposeinstagram.data.remote.RemoteLogin
>>>>>>> develop
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
<<<<<<< HEAD
    suspend fun doLogin():Response<LoginUIState>
=======
    suspend fun doLogin(): RemoteLogin
>>>>>>> develop
}