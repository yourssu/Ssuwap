package com.yourssu.imageselect.api

interface ImageStorage {
    suspend fun saveImage(bytes: ByteArray): String
}