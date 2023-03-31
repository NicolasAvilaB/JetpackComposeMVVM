package com.example.jetpackcomposeinstagram.presentation.listfruititems

import com.example.jetpackcomposeinstagram.data.listfruititems.ListFruitItemRepository
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsAction.*
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsResult.*
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
                if(list.isEmpty()) {
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