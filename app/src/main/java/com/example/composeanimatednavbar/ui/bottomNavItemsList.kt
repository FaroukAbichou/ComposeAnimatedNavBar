package com.example.composeanimatednavbar.ui


import android.content.res.Resources
import android.util.DisplayMetrics
import com.example.composeanimatednavbar.R

val bottomNavItems = listOf(
    BottomNavItem(
        name = "المتصدرين",
        route = "leaderboard",
        icon = R.drawable.badge,
        index = 0
    ),
    BottomNavItem(
        name = "الهدايا",
        route = "gifts",
        icon = R.drawable.gift,
        index = 1,
    ),
    BottomNavItem(
        name = "الرئيسية",
        route = "home",
        icon = R.drawable.home,
        index = 2,
    ),
    BottomNavItem(
        name = "الإشعارات",
        route = "notifications",
        icon = R.drawable.bell,
        index = 3,
    ),
    BottomNavItem(
        name = "الإعدادات",
        route = "settings",
        icon = R.drawable.settings,
        index = 4,
    ),
)



val bottomNavLineCods = listOf(
    LineCords(
        LineStart = 0F,
        LineEnd = 220F,
    ),
    LineCords(
        LineStart = 220F,
        LineEnd = 440F,
    ),
    LineCords(
        LineStart = 440F,
        LineEnd = 660F,
    ),
    LineCords(
        LineStart = 660F,
        LineEnd = 880F,
    ),
    LineCords(
        LineStart = 880F,
        LineEnd = 1120F,
    ),

)