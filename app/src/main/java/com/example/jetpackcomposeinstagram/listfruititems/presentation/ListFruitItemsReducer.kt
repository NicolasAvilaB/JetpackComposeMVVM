package com.example.jetpackcomposeinstagram.listfruititems.presentation

import com.example.jetpackcomposeinstagram.listfruititems.presentation.ListFruitItemsResult.*
import com.example.jetpackcomposeinstagram.listfruititems.presentation.ListFruitItemsUiState.*

class ListFruitItemsReducer {

    private fun unsupportedReduceCase() = RuntimeException()

    infix fun ListFruitItemsUiState.reduceWith(result: ListFruitItemsResult): ListFruitItemsUiState {
        return when (val previousState = this) {
            is LoadingUiState -> previousState reduceWith result
            is DisplayListFruitItemUiState -> previousState reduceWith result
            is EmptyUiState -> previousState reduceWith result
            is ErrorUiState -> previousState reduceWith result
            is DefaultUiState -> previousState reduceWith result
        }
    }

    infix fun LoadingUiState.reduceWith(result: ListFruitItemsResult) = when (result) {
        is GetListFruitItemResult.Success -> DisplayListFruitItemUiState(result.listFruitItems)
        is GetListFruitItemResult.Error -> ErrorUiState
        is GetListFruitItemResult.Empty -> EmptyUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun DisplayListFruitItemUiState.reduceWith(result: ListFruitItemsResult): ListFruitItemsUiState {
        throw unsupportedReduceCase()
    }

    private infix fun ErrorUiState.reduceWith(result: ListFruitItemsResult) = when (result) {
        is GetListFruitItemResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun EmptyUiState.reduceWith(result: ListFruitItemsResult) = when (result) {
        is GetListFruitItemResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun DefaultUiState.reduceWith(result: ListFruitItemsResult) = when (result) {
        is GetListFruitItemResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

}