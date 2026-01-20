package com.yourssu.transformresult

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

@Composable
fun TransformResultScreen(
    imageUri: String,
    onNavigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
) {
    println(imageUri)
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        AsyncImage(
            model = imageUri,
            contentDescription = "슝슝이 변환 이미지"
        )
    }
}