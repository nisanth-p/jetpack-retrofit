package com.neltech.retrofitex.firebase.crudrealtime

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController,
    sharedViewModel: ShareViewModel
) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.screenRoute) {

        //Main
        composable(Screen.MainScreen.screenRoute) {
            MainScreen(navController = navController)
        }
        //Add
        composable(Screen.AddScreen.screenRoute) {
            AddScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        //Get
        composable(Screen.GetScreen.screenRoute) {
           GetScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
    }
}