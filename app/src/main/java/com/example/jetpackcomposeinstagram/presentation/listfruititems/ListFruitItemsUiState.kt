package com.example.jetpackcomposeinstagram.presentation.listfruititems

sealed class ListFruitItemsUiState {
    object DefaultUiState : ListFruitItemsUiState()
    object LoadingUiState : ListFruitItemsUiState()
    data class DisplayListFruitItemUiState(val listFruitItem: List<String>) : ListFruitItemsUiState()
    object ErrorUiState : ListFruitItemsUiState()
    object EmptyUiState : ListFruitItemsUiState()
}