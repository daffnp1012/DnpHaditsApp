package com.dnpstudio.dnphaditsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dnpstudio.dnphaditsapp.navigation.ScreenRoute
import com.dnpstudio.dnphaditsapp.ui.home.HomeScreen
import com.dnpstudio.dnphaditsapp.ui.splash.SplashScreen

@Composable
fun DnpHaditsApp(
    navHostController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navHostController,
        startDestination = ScreenRoute.splash.route
    ){
        composable(ScreenRoute.splash.route){
            SplashScreen()
        }
        composable(ScreenRoute.home.route){
            HomeScreen()
        }
    }
    
}