package com.yourssu.imageselect

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ImageSelectController(
    private val imageLauncher: ImageLauncher
) {
    var selectedImageUri by mutableStateOf<String?>(null)
        private set

    fun onGalleryClick() {
        imageLauncher.launchGallery { uri ->
            selectedImageUri = uri
        }
    }

    fun onCameraResult(uri: String?) {
        if (uri != null) {
            selectedImageUri = uri
        }
    }

    fun isImageSelected(): Boolean = selectedImageUri != null
}