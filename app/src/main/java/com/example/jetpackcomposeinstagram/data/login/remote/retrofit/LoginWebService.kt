package com.example.jetpackcomposeinstagram.data.login.remote.retrofit

import com.example.jetpackcomposeinstagram.data.login.remote.model.RemoteLogin
import retrofit2.http.GET

interface LoginWebService {
    @GET("/v3/b6295294-f186-4e8a-a356-b4110718d082")
    suspend fun doLogin(): RemoteLogin
}