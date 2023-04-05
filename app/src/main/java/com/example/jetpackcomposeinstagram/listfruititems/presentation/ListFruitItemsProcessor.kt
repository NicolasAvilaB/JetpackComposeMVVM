package com.example.jetpackcomposeinstagram.listfruititems.presentation

import com.example.jetpackcomposeinstagram.listfruititems.data.ListFruitItemRepository
import com.example.jetpackcomposeinstagram.listfruititems.presentation.ListFruitItemsAction.*
import com.example.jetpackcomposeinstagram.listfruititems.presentation.ListFruitItemsResult.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class ListFruitItemsProcessor {

    private val repository = ListFruitItemRepository()
    fun actionProcessor(actions: ListFruitItemsAction): Flow<GetListFruitItemResult> =
        when (actions) {
            GetListFruitItemAction -> onLoadListFruitItemProcessor()
        }

    private fun onLoadListFruitItemProcessor(): Flow<GetListFruitItemResult> =
        repository.getListFruitItems()
            .map { list ->
                if(list!!.isEmpty()) {
                    GetListFruitItemResult.Empty
                }else{
                    GetListFruitItemResult.Success(list)
                }
            }
            .onStart {
                emit(GetListFruitItemResult.InProgress)
            }
            .catch {
                emit(GetListFruitItemResult.Error)
            }
            .flowOn(Dispatchers.IO)
}