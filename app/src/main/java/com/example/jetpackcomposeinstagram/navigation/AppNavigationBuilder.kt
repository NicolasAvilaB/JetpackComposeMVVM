package com.example.jetpackcomposeinstagram.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.jetpackcomposeinstagram.R

@Composable
fun AppNavigationBuilder (navController: NavController){
    val home : String = stringResource(id = R.string.home)
    var isselected by remember { mutableStateOf(false) }
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(home)
            },
            selected = !isselected,
            onClick = {navController.navigate(route = routes.ListFruitItemsScreen.routes)}
        )
    }
}