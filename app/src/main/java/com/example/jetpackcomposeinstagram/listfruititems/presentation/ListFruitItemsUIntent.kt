package com.example.jetpackcomposeinstagram.listfruititems.presentation

sealed class ListFruitItemsUIntent {
    object GetListFruitItemUIntent : ListFruitItemsUIntent()
    object RetryUIntent : ListFruitItemsUIntent()
}