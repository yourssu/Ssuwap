package com.yourssu.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onNavigateToImageSelect: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("샘플!")
    }
}