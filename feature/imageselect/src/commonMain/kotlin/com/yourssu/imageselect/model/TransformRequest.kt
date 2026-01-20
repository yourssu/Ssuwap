package com.yourssu.imageselect.model

import kotlinx.serialization.Serializable

@Serializable
data class TransformRequest(
    val imageUri: String
)