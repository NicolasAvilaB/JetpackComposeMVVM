package com.example.jetpackcomposeinstagram.ui.listfruititems.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeinstagram.ui.listfruititems.ListFruitItemsIntentHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun ListFruitItemComponent(listFruitItems: List<String>, intentHandler: ListFruitItemsIntentHandler) {
    var showAddItemDialog by rememberSaveable {
        mutableStateOf(false)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            /*Button(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp),
                onClick = {
                    showAddItemDialog = true
                }) {
                Text(text = stringResource(id = R.string.poc_add_item))
            }*/
        }
        items(items = listFruitItems) { name ->
            CardItemSection(name = name)
        }
    }
    /*AddItemDialog(
        show = showAddItemDialog,
        onDismiss = {
            showAddItemDialog = false
        },
        onItemAdded = {
            showAddItemDialog = false
            intentHandler.addItemShoppingUIntent(it)
        })*/
}

@Composable
fun CardItemSection(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 3.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(text = name)
        }
    }
}


