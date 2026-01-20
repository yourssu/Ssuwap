package com.yourssu.imageselect

interface ImageLauncher {
    fun launchGallery(onImageSelected: (String) -> Unit)
}