package com.yourssu.camera

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun CameraScreen(
    onPhotoCaptured: (String) -> Unit,
    modifier: Modifier = Modifier,
)