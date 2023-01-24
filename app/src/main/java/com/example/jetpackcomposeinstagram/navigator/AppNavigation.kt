package com.example.jetpackcomposeinstagram.navigator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeinstagram.ui.listfruititems.ListFruitItemsScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Navgraphroutes.ListFruitItemsScreen.routes)
    {
        composable(route = Navgraphroutes.ListFruitItemsScreen.routes){
            //ListFruitItemsScreen(modifier = Modifier)
        }
    }
}