package com.example.jetpackcomposeinstagram.listfruititems.data

import com.example.jetpackcomposeinstagram.listfruititems.data.remote.ListFruitRemoteImpl
import com.example.jetpackcomposeinstagram.listfruititems.data.remote.model.RemoteList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListFruitItemRepository {

    val listFruit = ListFruitRemoteImpl()

    fun getListFruitItems(): Flow<List<RemoteList?>?> = flow {
        val response = listFruit.getListFruit()
        emit(response as List<RemoteList?>?)
    }
}