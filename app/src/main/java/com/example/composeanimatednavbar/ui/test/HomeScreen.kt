package com.example.composeanimatednavbar.ui.test

import android.util.DisplayMetrics
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Text(
            text = "Home Screen",
            modifier = Modifier
                .align(
                    Alignment.Center
                )
        )
    }
}