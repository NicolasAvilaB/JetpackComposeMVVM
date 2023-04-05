package com.example.jetpackcomposeinstagram.listfruititems.ui

import com.example.jetpackcomposeinstagram.listfruititems.presentation.ListFruitItemsUIntent
import com.example.jetpackcomposeinstagram.listfruititems.presentation.ListFruitItemsUIntent.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class ListFruitItemsIntentHandler {
    private val listfruititemsIntents = MutableSharedFlow<ListFruitItemsUIntent>()
    var coroutineScope: CoroutineScope? = null

    internal fun userIntents(): Flow<ListFruitItemsUIntent> = listfruititemsIntents.asSharedFlow()

    fun getListShoppingUIntent() {
        coroutineScope?.launch {
            listfruititemsIntents.emit(GetListFruitItemUIntent)
        }
    }

    fun retryIntent() {
        coroutineScope?.launch {
            listfruititemsIntents.emit(RetryUIntent)
        }
    }
}