package com.yourssu.imageselect

import Ssuwap.feature.imageselect.BuildConfig
import com.yourssu.imageselect.api.ImageDataSource
import com.yourssu.imageselect.query.TransformImageMutation
import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import dev.shreyaspatil.ai.client.generativeai.type.generationConfig
import dev.zacsweers.metro.GraphExtension
import dev.zacsweers.metro.Provides

@GraphExtension
interface ImageSelectGraph {
    val imageLauncher: ImageLauncher
    val imageDataSource: ImageDataSource

    val transformImageMutation: TransformImageMutation
    val imageSelectController: ImageSelectController

    @Provides
    fun provideImageSelectController(): ImageSelectController {
        return ImageSelectController(imageLauncher)
    }

    @Provides
    fun provideGenerativeModel(): GenerativeModel {
        return GenerativeModel(
            modelName = "gemini-2.5-flash-image",
            apiKey = BuildConfig.GEMINI_API_KEY,
        )
    }

    @GraphExtension.Factory
    interface Factory {
        fun createImageSelectGraph(): ImageSelectGraph
    }
}