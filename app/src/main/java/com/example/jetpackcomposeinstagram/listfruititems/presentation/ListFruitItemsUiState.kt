package com.example.jetpackcomposeinstagram.listfruititems.presentation

import com.example.jetpackcomposeinstagram.listfruititems.data.remote.model.RemoteList

sealed class ListFruitItemsUiState {
    object DefaultUiState : ListFruitItemsUiState()
    object LoadingUiState : ListFruitItemsUiState()
    data class DisplayListFruitItemUiState(val listFruitItem: List<RemoteList?>?) : ListFruitItemsUiState()
    object ErrorUiState : ListFruitItemsUiState()
    object EmptyUiState : ListFruitItemsUiState()
}