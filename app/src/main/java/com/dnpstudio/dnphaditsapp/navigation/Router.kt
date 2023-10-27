package com.dnpstudio.dnphaditsapp.navigation

sealed class ScreenRoute(val route: String){
    object splash: ScreenRoute("splash")
    object home: ScreenRoute("home")
    object detail: ScreenRoute("detail")
}
