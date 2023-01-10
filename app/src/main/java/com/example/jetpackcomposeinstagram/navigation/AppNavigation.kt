package com.example.jetpackcomposeinstagram.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeinstagram.ui.listfruititems.ListFruitItemsScreen

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