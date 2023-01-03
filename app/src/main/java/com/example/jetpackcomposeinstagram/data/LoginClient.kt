package com.example.jetpackcomposeinstagram.data

import com.example.jetpackcomposeinstagram.data.remote.models.RemoteLogin
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/b6295294-f186-4e8a-a356-b4110718d082")
    suspend fun doLogin(): RemoteLogin
}