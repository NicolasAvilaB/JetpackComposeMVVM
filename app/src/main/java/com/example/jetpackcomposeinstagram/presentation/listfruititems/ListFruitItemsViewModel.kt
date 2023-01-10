package com.example.jetpackcomposeinstagram.presentation.listfruititems

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsAction.GetListFruitItemAction
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsUIntent.GetListFruitItemUIntent
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsUIntent.RetryUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*

class ListFruitItemsViewModel : ViewModel() {
    private val reducer = ListFruitItemsReducer()
    private val processor = ListFruitItemsProcessor()

    fun listfruititemsuiState(): StateFlow<ListFruitItemsUiState> = listfruititemuiState
    val listfruititemsDefaultUiState: ListFruitItemsUiState = ListFruitItemsUiState.DefaultUiState
    private val listfruititemuiState: MutableStateFlow<ListFruitItemsUiState> = MutableStateFlow(listfruititemsDefaultUiState)

    fun processUserIntentsAndObserveUiStates(
        listfruititemsIntents: Flow<ListFruitItemsUIntent>,
        coroutineScope: CoroutineScope = viewModelScope,
    ) {
        listfruititemsIntents.buffer()
            .flatMapMerge { listfruititemsIntent ->
                processor.actionProcessor(listfruititemsIntent.toAction())
            }
            .scan(listfruititemsDefaultUiState) { previousUiState, result ->
                with(reducer) { previousUiState reduceWith result }
            }
            .onEach { listfruitstate ->
                listfruititemuiState.value = listfruitstate
            }
            .launchIn(coroutineScope)
    }

    private fun ListFruitItemsUIntent.toAction(): ListFruitItemsAction {
        return when (this) {
            is GetListFruitItemUIntent -> GetListFruitItemAction
            is RetryUIntent -> GetListFruitItemAction
        }
    }
}