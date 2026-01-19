package com.yourssu.ssuwap

import com.yourssu.imageselect.ImageLauncher
import com.yourssu.imageselect.IosImageDataSource
import com.yourssu.imageselect.IosImageLauncher
import com.yourssu.imageselect.api.ImageDataSource
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides

@DependencyGraph(AppScope::class)
interface IosAppGraph : AppGraph {

    @Provides
    fun provideImageLauncher(): ImageLauncher {
        return IosImageLauncher()
    }

    @Provides
    fun provideImageDataSource(): ImageDataSource {
        return IosImageDataSource()
    }

    @DependencyGraph.Factory
    fun interface Factory {
        fun createIosAppGraph(): IosAppGraph
    }

}