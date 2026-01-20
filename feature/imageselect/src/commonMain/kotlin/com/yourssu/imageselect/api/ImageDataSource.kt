package com.yourssu.imageselect.api

interface ImageDataSource {
    suspend fun getImageData(uri: String): ByteArray?
}
