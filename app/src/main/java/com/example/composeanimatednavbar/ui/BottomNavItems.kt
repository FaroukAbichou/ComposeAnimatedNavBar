package com.example.composeanimatednavbar.ui

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: Int,
    val index: Int,
)
data class LineCords(
    val LineStart : Float,
    val LineEnd : Float,
)