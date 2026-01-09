package com.yourssu.ssuwap

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade

@Composable
context(appGraph: AppGraph)
fun SsuwapApp() {

    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .crossfade(true)
            .build()
    }

    MaterialTheme {
        SsuwapAppUi()
    }

}