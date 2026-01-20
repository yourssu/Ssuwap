package com.yourssu.imageselect

import com.yourssu.imageselect.api.ImageStorage
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.NSTemporaryDirectory
import platform.Foundation.NSURL
import platform.Foundation.NSUUID
import platform.Foundation.create
import platform.Foundation.writeToFile

class IosImageStorage : ImageStorage {
    @OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
    override suspend fun saveImage(bytes: ByteArray): String {
        val data = bytes.usePinned { pinned ->
            NSData.create(bytes = pinned.addressOf(0), length = bytes.size.toULong())
        }

        val fileName = "${NSUUID().UUIDString}.png"
        val tempDir = NSTemporaryDirectory()
        val fileUrl = NSURL.fileURLWithPath(tempDir).URLByAppendingPathComponent(fileName)
        val filePath = fileUrl?.path ?: throw IllegalStateException("Failed to create temp file path")

        data.writeToFile(filePath, true)

        return fileUrl.absoluteString ?: ""
    }
}