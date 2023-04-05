package com.example.jetpackcomposeinstagram.listfruititems.presentation

import com.example.jetpackcomposeinstagram.listfruititems.data.remote.model.RemoteList

sealed class ListFruitItemsResult {

    sealed class GetListFruitItemResult : ListFruitItemsResult() {
        object InProgress : GetListFruitItemResult()
        data class Success(val listFruitItems: List<RemoteList?>?) : GetListFruitItemResult()
        object Error : GetListFruitItemResult()
        object Empty : GetListFruitItemResult()
    }

}