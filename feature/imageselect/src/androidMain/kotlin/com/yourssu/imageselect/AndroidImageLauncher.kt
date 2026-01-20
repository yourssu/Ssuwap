package com.yourssu.imageselect

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

object AndroidImageLauncher : ImageLauncher {
    private var activityLauncher: ActivityResultLauncher<PickVisualMediaRequest>? = null
    private var onImageSelectedCallback: ((String) -> Unit)? = null


    fun registerLauncher(launcher: ActivityResultLauncher<PickVisualMediaRequest>) {
        this.activityLauncher = launcher
    }


    fun onResult(uri: android.net.Uri?) {
        if (uri != null) {
            onImageSelectedCallback?.invoke(uri.toString())
        }
        onImageSelectedCallback = null
    }

    override fun launchGallery(onImageSelected: (String) -> Unit) {
        this.onImageSelectedCallback = onImageSelected

        activityLauncher?.launch(
            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        ) ?: println("Error: Launcher is not registered. Call registerLauncher() in Activity.")
    }
}