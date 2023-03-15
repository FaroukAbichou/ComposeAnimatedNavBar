package com.example.composeanimatednavbar.core


import com.example.composeanimatednavbar.R
import com.example.composeanimatednavbar.core.model.BottomNavItem

val bottomNavItemsList = listOf(
    BottomNavItem(
        name = "Leaderboard",
        route = "leaderboard",
        icon = R.drawable.badge,
        index = 0
    ),
    BottomNavItem(
        name = "Gifts",
        route = "gifts",
        icon = R.drawable.gift,
        index = 1,
    ),
    BottomNavItem(
        name = "Home",
        route = "home",
        icon = R.drawable.home,
        index = 2,
    ),
    BottomNavItem(
        name = "Notifications",
        route = "notifications",
        icon = R.drawable.bell,
        index = 3,
    ),
    BottomNavItem(
        name = "Settings",
        route = "settings",
        icon = R.drawable.settings,
        index = 4,
    ),
)

