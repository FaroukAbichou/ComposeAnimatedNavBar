package com.example.composeanimatednavbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeanimatednavbar.ui.bottomNavItems
import com.example.composeanimatednavbar.ui.drawColoredShadow
import com.example.composeanimatednavbar.ui.test.NavGraph
import com.example.composeanimatednavbar.ui.theme.ComposeAnimatedNavBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimatedNavBarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimatedNavBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnimatedNavBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val lineStart = remember { mutableStateOf(0.0F) }
    val lineEnd = remember { mutableStateOf(220.0F) }

    val end1Counter by animateFloatAsState(
        targetValue = lineStart.value,
        animationSpec = tween(
            durationMillis = 2000,
            easing = FastOutSlowInEasing
        )
    )
    val end2Counter by animateFloatAsState(
        targetValue = lineEnd.value,
        animationSpec = tween(
            durationMillis = 5000,
            easing = FastOutSlowInEasing
        )
    )



    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .drawColoredShadow(
                        color = Color.Black,
                        spread = 8.dp,
                    )
                    .clip(
                        RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                    )
                    .height(84.dp),
                containerColor = MaterialTheme.colorScheme.onPrimary

            ) {
                Box(
                    Modifier.fillMaxWidth()
                ) {
                    LineAnimation(
                        startX = 0f,
                        startY = 0f,
                        endX = 220f,
                        endY = 0f,
                    )
                    bottomNavItems.forEach { item ->
                        this@BottomAppBar.NavigationBarItem(
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id)
                                    launchSingleTop = true


                                }
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



            }
        }
    ){
        NavGraph(
            navController
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAnimatedNavBarTheme {
        AnimatedNavBar()
    }

}
@SuppressLint("RememberReturnType")
@Composable
fun LineAnimation(
    startX :Float,
    endX :Float,
    startY :Float,
    endY :Float,
) {


    Canvas(
        modifier = Modifier
            .height(20.dp)

    ) {
        drawLine(
            color = Color.Black,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = 6f
        )
    }
}