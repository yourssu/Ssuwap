package com.yourssu.imageselect.api

import androidx.compose.ui.graphics.ImageBitmap

interface ImageTransformer {
    suspend fun uploadAndTransform(image: ImageBitmap): String
}