package com.example.jetpackcomposeinstagram.ui.listfruititems

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposeinstagram.R
import com.example.jetpackcomposeinstagram.navigation.AppNavigationBuilder

@Composable
fun ListFruitItemsScreen(navController: NavController, modifier: Modifier){
    val home : String = stringResource(id = R.string.home)
    Scaffold(topBar = {
        TopAppBar() {
            Spacer(modifier.width(10.dp))
            Text(text = home)
        }
    }) {
        Scaffold(
            bottomBar = { AppNavigationBuilder(navController) },
        ) {

        }
    }
}