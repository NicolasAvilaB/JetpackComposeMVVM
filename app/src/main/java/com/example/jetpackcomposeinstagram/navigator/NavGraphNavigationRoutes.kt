package com.example.jetpackcomposeinstagram.navigator

sealed class Navgraphroutes(var routes: String){
    object ListFruitItemsScreen: Navgraphroutes("listfruititemsscreen")
}