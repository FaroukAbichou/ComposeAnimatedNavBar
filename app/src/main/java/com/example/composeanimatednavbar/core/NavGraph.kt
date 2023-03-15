package com.example.composeanimatednavbar.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.composeanimatednavbar.ui.screens.*


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = bottomNavItemsList[2] .route
    ) {
        composable(route = bottomNavItemsList[0].route) {
            LeaderBoardScreen()
        }
        composable(route = bottomNavItemsList[1].route) {
            GiftsScreen()
        }
        composable(route = bottomNavItemsList[2].route) {
            HomeScreen()
        }
        composable(route = bottomNavItemsList[3].route) {
            NotificationScreen()
        }
        composable(route = bottomNavItemsList[4].route) {
            SettingsScreen()
        }
    }
}

