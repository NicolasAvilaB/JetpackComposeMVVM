package com.example.jetpackcomposeinstagram.navigator

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jetpackcomposeinstagram.presentation.listfruititems.ListFruitItemsViewModel
import com.example.jetpackcomposeinstagram.ui.listfruititems.ListFruitItemsScreen

/*@Composable
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
}*/

@ExperimentalAnimationApi
internal fun NavGraphBuilder.listfruititemnav(
    onBackEvent: () -> Unit = {},
    onNextScreenEvent: () -> Unit = {},
    viewmodel: ListFruitItemsViewModel
) = composable(
    route = Navgraphroutes.ListFruitItemsScreen.routes,
) {

    ListFruitItemsScreen(
        onBack = onBackEvent,
        onNextScreen = onNextScreenEvent,
        viewmodel = viewmodel,
        modifier = Modifier
    )
}