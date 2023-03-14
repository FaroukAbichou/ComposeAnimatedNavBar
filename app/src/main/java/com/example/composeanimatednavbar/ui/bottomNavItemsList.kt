package com.example.composeanimatednavbar.ui


import com.example.composeanimatednavbar.R

val bottomNavItems = listOf(
    BottomNavItem(
        name = "المتصدرين",
        route = "leaderboard",
        icon = R.drawable.badge,
    ),
    BottomNavItem(
        name = "الهدايا",
        route = "gifts",
        icon = R.drawable.gift,
    ),
    BottomNavItem(
        name = "الرئيسية",
        route = "home",
        icon = R.drawable.home,
    ),
    BottomNavItem(
        name = "الإشعارات",
        route = "notifications",
        icon = R.drawable.bell,
    ),
    BottomNavItem(
        name = "الإعدادات",
        route = "settings",
        icon = R.drawable.settings,
    ),
)
