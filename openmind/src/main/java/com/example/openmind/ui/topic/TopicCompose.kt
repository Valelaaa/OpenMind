package com.example.openmind.ui.screen.Article

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun TopicLayout(navController: NavController, modifier: Modifier = Modifier.fillMaxSize()) {
    Column(
        verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Article Layout")
    }
}