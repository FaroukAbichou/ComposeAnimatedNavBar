package com.example.composeanimatednavbar.ui.test

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.composeanimatednavbar.ui.bottomNavItems


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = bottomNavItems[2] .route
    ) {
        composable(route = bottomNavItems[0].route) {
            LeaderBoardScreen()
        }
        composable(route = bottomNavItems[1].route) {
            GiftsScreen()
        }
        composable(route = bottomNavItems[2].route) {
            HomeScreen()
        }
        composable(route = bottomNavItems[3].route) {
            NotificationScreen()
        }
        composable(route = bottomNavItems[4].route) {
            SettingsScreen()
        }
    }
}

