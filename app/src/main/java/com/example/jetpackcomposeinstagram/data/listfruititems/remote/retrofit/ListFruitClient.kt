package com.example.jetpackcomposeinstagram.data.listfruititems.remote.retrofit

import com.example.jetpackcomposeinstagram.data.listfruititems.remote.model.RemoteListFruit
import retrofit2.http.GET

interface ListFruitClient {
    @GET("/v3/b6295294-f186-4e8a-a356-b4110718d082")
    suspend fun getListFruit(): RemoteListFruit
}