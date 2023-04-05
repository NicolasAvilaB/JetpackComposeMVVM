package com.example.jetpackcomposeinstagram.listfruititems.data.remote

import com.example.jetpackcomposeinstagram.listfruititems.data.Retrofit
import com.example.jetpackcomposeinstagram.listfruititems.data.remote.retrofit.ListFruitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListFruitRemoteImpl {
    private val retrofit = Retrofit()

    suspend fun getListFruit():Any {
        return withContext(Dispatchers.IO){
            retrofit.getRetrofit().create(ListFruitClient::class.java).getListFruit()
        }
    }
}