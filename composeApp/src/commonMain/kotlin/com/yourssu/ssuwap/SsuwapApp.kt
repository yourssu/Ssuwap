package com.yourssu.ssuwap

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import com.yourssu.designsystem.theme.SsuwapTheme
import soil.query.SwrCache
import soil.query.SwrCacheScope
import soil.query.compose.SwrClientProvider

@Composable
context(appGraph: AppGraph)
fun SsuwapApp() {

    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .crossfade(true)
            .build()
    }
    SwrClientProvider(SwrCache(SwrCacheScope())) {
        SsuwapTheme {
            SsuwapAppUi()
        }
    }
}