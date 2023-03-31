package com.example.jetpackcomposeinstagram.data.listfruititems

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListFruitItemRepository {
    val listFruit = mutableListOf("Tomates", "Arroz", "Pollo", "Arvejas")

    fun getListFruitItems(): Flow<List<String>> = flow {
        delay(500)
        emit(listFruit)
    }
}