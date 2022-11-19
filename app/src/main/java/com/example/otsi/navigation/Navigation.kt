package com.example.otsi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.otsi.presentation.screen.login.LoginScreen

@Composable
fun setUpNavigation(navController:NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Login.route ){
        composable(route = Screen.Login.route){
            LoginScreen(navHostController = navController)
        }
        composable(route = Screen.Profile.route){

        }
    }

}