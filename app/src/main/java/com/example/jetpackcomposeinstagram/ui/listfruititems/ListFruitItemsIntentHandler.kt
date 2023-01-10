package com.example.jetpackcomposeinstagram.ui.listfruititems

import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListShoppingUIntent
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListShoppingUIntent.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class ShoppingIntentHandler {
    private val shoppingIntents = MutableSharedFlow<ListShoppingUIntent>()
    var coroutineScope: CoroutineScope? = null

    internal fun userIntents(): Flow<ListShoppingUIntent> = shoppingIntents.asSharedFlow()

    fun getListShoppingUIntent() {
        coroutineScope?.launch {
            shoppingIntents.emit(GetListFruitItemUIntent)
        }
    }

    fun retryIntent() {
        coroutineScope?.launch {
            shoppingIntents.emit(RetryUIntent)
        }
    }
}