package com.example.jetpackcomposeinstagram.navigator

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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