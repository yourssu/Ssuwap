package com.yourssu.imageselect

import android.content.Context
import android.net.Uri
import com.yourssu.imageselect.api.ImageDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.FileNotFoundException

class AndroidImageDataSource(
    private val context: Context
) : ImageDataSource {

    override suspend fun getImageData(uri: String): ByteArray? = withContext(Dispatchers.IO) {
        try {
            val parsedUri = Uri.parse(uri)
            context.contentResolver.openInputStream(parsedUri)?.use { inputStream ->
                inputStream.readBytes()
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}