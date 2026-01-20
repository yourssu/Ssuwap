package com.yourssu.ssuwap.navigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data object ImageSelectRoute

@Serializable
data object CameraRoute

@Serializable
data class TransformResultRoute(
    val resultUri: String
)