package com.example.jetpackcomposeinstagram.navigator

sealed class routes(var routes: String){
    object ListFruitItemsScreen: routes("listfruititemsscreen")
}