package com.yourssu.ssuwap

import android.content.Context
import com.yourssu.imageselect.AndroidImageDataSource
import com.yourssu.imageselect.AndroidImageLauncher
import com.yourssu.imageselect.ImageLauncher
import com.yourssu.imageselect.api.ImageDataSource
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides

@DependencyGraph(AppScope::class)
interface AndroidAppGraph : AppGraph {

    @Provides
    fun provideImageLauncher(): ImageLauncher = AndroidImageLauncher()

    @Provides
    fun provideImageDataSource(context: Context): ImageDataSource = AndroidImageDataSource(context)

    @DependencyGraph.Factory
    fun interface Factory {
        fun createAndroidAppGraph(
            @Provides applicationContext: Context,
        ): AndroidAppGraph
    }

}