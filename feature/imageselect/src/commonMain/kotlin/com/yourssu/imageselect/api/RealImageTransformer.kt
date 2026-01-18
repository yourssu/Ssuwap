//package com.yourssu.imageselect.api
//
//import androidx.compose.ui.graphics.ImageBitmap
//
//class RealImageTransformer(private val client: HttpClient) : ImageTransformer {
//    override suspend fun uploadAndTransform(image: ImageBitmap): String {
//        return client.post("...") { ... }.body()
//    }
//}