package com.yourssu.imageselect

import android.content.Context
import com.yourssu.imageselect.api.ImageStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

class AndroidImageStorage(private val context: Context) : ImageStorage {
    override suspend fun saveImage(bytes: ByteArray): String = withContext(Dispatchers.IO) {
        val fileName = "gemini_generated_${System.currentTimeMillis()}.png"
        val file = File(context.cacheDir, fileName)
        
        FileOutputStream(file).use { output ->
            output.write(bytes)
        }
        
        file.toURI().toString()
    }
}