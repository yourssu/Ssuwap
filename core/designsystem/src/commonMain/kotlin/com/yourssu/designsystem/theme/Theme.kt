package com.yourssu.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

private val lightScheme = lightColorScheme(
    primary = primaryBlue,
    surface = surfaceBlue,
    background = Color.White,
)

@Composable
fun SsuwapTheme(
    fontFamily: FontFamily? = null,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = lightScheme,
        content = content,
    )
}