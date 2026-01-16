package com.yourssu.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class HomeLogic(
    private val navigateToNext: () -> Unit,
) {
    var isLoading by mutableStateOf(false)
        private set

    fun onStartClick() {
        isLoading = true
        navigateToNext()
        isLoading = false
    }
}