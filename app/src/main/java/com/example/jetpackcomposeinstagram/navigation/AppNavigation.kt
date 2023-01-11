package com.example.jetpackcomposeinstagram.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsViewModel
import com.example.jetpackcomposeinstagram.ui.listfruititems.ListFruitItemsIntentHandler
import com.example.jetpackcomposeinstagram.ui.listfruititems.ListFruitItemsScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = routes.ListFruitItemsScreen.routes)
    {
        composable(route = routes.ListFruitItemsScreen.routes){
            ListFruitItemsScreen(navController, modifier = Modifier)
        }
    }
}