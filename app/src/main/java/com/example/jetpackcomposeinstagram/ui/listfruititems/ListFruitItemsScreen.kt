package com.example.jetpackcomposeinstagram.ui.listfruititems

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposeinstagram.R
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsUiState
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsViewModel
import com.example.jetpackcomposeinstagram.ui.listfruititems.components.ListFruitItemComponent
import com.example.jetpackcomposeinstagram.ui.listfruititems.components.LoadingComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
@Composable
fun ListFruitItemsScreen(
    modifier: Modifier,
    viewmodel: ListFruitItemsViewModel,
    onBack: () -> Unit = {},
    onNextScreen: () -> Unit = {},
) {
    val listFruitItemViewModel: ListFruitItemsViewModel = viewModel()
    val listFruitItemIntentHandler = ListFruitItemsIntentHandler().apply {
        this.coroutineScope = rememberCoroutineScope()
    }
    listFruitItemViewModel.processUserIntentsAndObserveUiStates(listFruitItemIntentHandler.userIntents())
    val userUiState = remember { listFruitItemViewModel.listfruititemsuiState() }.collectAsState(initial = listFruitItemViewModel.listfruititemsDefaultUiState)

    val home: String = stringResource(id = R.string.home)
    Scaffold(topBar = {
        TopAppBar() {
            Spacer(modifier.width(10.dp))
            Text(text = home)
        }
    }) {
        Scaffold(
            //bottomBar = { AppNavigationBuilder(navController) },
        ) {
            ListFruitItemsContent(
                intentHandler = listFruitItemIntentHandler,
                uiState = userUiState
            )
        }
    }
}

@ExperimentalCoroutinesApi
@FlowPreview
@Composable
private fun ListFruitItemsContent(
    intentHandler: ListFruitItemsIntentHandler,
    uiState: State<ListFruitItemsUiState>,
) {
    when (val currentState = uiState.value) {
        is ListFruitItemsUiState.DefaultUiState -> {
            intentHandler.getListShoppingUIntent()
        }
        is ListFruitItemsUiState.DisplayListFruitItemUiState -> ListFruitItemComponent(
            listFruitItems = currentState.listFruitItem,
            intentHandler = intentHandler
        )
        is ListFruitItemsUiState.EmptyUiState -> {
            intentHandler.retryIntent()
        }
        is ListFruitItemsUiState.ErrorUiState -> {
            intentHandler.retryIntent()
        }
        ListFruitItemsUiState.LoadingUiState -> LoadingComponent()
    }
}