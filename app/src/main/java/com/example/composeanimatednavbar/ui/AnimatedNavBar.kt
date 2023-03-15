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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeanimatednavbar.core.bottomNavItemsList
import com.example.composeanimatednavbar.core.NavGraph


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnimatedNavBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BoxWithConstraints(

                modifier = Modifier

                    .clip(
                        RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                    )
            ) {
                val firstEnd = maxWidth/5

                val lineEnd = remember { mutableStateOf(firstEnd*2) }

                val lineEndCounter by animateDpAsState(
                    targetValue = lineEnd.value,
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = FastOutSlowInEasing
                    )
                )

                BottomAppBar(
                    containerColor = Color(0xffe7c8e7)
                ) {

                    bottomNavItemsList.forEach { item ->
                        NavigationBarItem(
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id)
                                    launchSingleTop = true
                                }
                                lineEnd.value = firstEnd * item.index
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
                                    fontSize = 10.sp
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color(0xff0d0b33),
                                unselectedIconColor = Color(0xff4c2f6f),
                                indicatorColor = Color(0xffe7c8e7)
                            ),
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .width(
                            maxWidth/5
                        )
                        .padding(horizontal = 8.dp)
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
