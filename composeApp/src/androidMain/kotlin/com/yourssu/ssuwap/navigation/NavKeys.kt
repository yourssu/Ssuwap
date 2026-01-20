package com.yourssu.ssuwap.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object HomeNavKey : NavKey

@Serializable
data class ImageSelectNavKey(
    val selectedUri: String? = null
) : NavKey

@Serializable
data object CameraNavKey : NavKey

@Serializable
data object TransformResultNavKey : NavKey