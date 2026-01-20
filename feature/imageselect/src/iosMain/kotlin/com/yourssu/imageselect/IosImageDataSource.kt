package com.yourssu.imageselect

import com.yourssu.imageselect.api.ImageDataSource
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.get
import kotlinx.cinterop.reinterpret
import platform.Foundation.NSData
import platform.Foundation.NSURL
import platform.Foundation.dataWithContentsOfURL

class IosImageDataSource : ImageDataSource {
    override suspend fun getImageData(uri: String): ByteArray? {
        val nsUrl = NSURL.URLWithString(uri) ?: return null
        val data = NSData.dataWithContentsOfURL(nsUrl) ?: return null
        
        return data.toByteArray()
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun NSData.toByteArray(): ByteArray {
        val bytes = this.bytes?.reinterpret<ByteVar>() ?: return ByteArray(0)
        val length = this.length.toInt()
        return ByteArray(length) { index -> bytes[index] }
    }
}