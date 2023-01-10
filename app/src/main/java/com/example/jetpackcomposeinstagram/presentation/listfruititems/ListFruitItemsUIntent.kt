package com.example.jetpackcomposeinstagram.presentation.listfruititems

sealed class ListFruitItemsUIntent {
    object GetListFruitItemUIntent : ListFruitItemsUIntent()
    object RetryUIntent : ListFruitItemsUIntent()
}