package com.example.jetpackcomposeinstagram.presentation.listfruititems

sealed class ListFruitItemsResult {

    sealed class GetListFruitItemResult : ListFruitItemsResult() {
        object InProgress : GetListFruitItemResult()
        data class Success(val listFruitItems: List<String>) : GetListFruitItemResult()
        object Error : GetListFruitItemResult()
        object Empty : GetListFruitItemResult()
    }

}