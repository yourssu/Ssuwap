package com.yourssu.imageselect

import dev.zacsweers.metro.GraphExtension
import dev.zacsweers.metro.Provides

@GraphExtension
interface ImageSelectGraph {
    val imageLauncher: ImageLauncher

    @Provides
    fun provideImageSelectController(): ImageSelectController {
        return ImageSelectController(imageLauncher)
    }

    @GraphExtension.Factory
    interface Factory {
        fun createImageSelectGraph(): ImageSelectGraph
    }
}