package com.example.composeanimatednavbar.ui

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeanimatednavbar.core.bottomNavItemsList
import com.example.composeanimatednavbar.core.drawColoredShadow
import com.example.composeanimatednavbar.ui.screens.NavGraph


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnimatedNavBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val lineEnd = remember { mutableStateOf(0.dp) }

    val lineEndCounter by animateDpAsState(
        targetValue = lineEnd.value,
        animationSpec = tween(
            durationMillis = 200,
            easing = FastOutSlowInEasing
        )
    )

    Scaffold(
        bottomBar = {
            BoxWithConstraints(

                modifier = Modifier
                    .drawColoredShadow(
                        color = Color.Black,
                        spread = 8.dp,
                    )
                    .clip(
                        RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                    )
                    .height(84.dp),
            ) {
                val firstEnd = maxWidth/5

                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ) {

                    bottomNavItemsList.forEach { item ->
                        NavigationBarItem(
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id)
                                    launchSingleTop = true
                                }
                                lineEnd.value = firstEnd*item.index
                            },
                            selected = currentRoute == item.route ,
                            icon = {
                                Icon(
                                    painterResource(id = item.icon),
                                    contentDescription = item.name,
                                )

                            },
                            label = {
                                Text(
                                    text = item.name,
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Black,
                                unselectedIconColor = MaterialTheme.colorScheme.outline,
                                indicatorColor = MaterialTheme.colorScheme.onPrimary
                            ),
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .drawColoredShadow(
                            color = Color.Cyan,
                            spread = 10.dp,
                        )
                        .width(
                            maxWidth/5
                        )
                        .height(2.dp)
                        .offset(
                            with(LocalDensity.current){
                                lineEndCounter
                            },
                            0.dp
                        )
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Black)
                )
            }
        }
    ){
        NavGraph(
            navController
        )
    }
}
