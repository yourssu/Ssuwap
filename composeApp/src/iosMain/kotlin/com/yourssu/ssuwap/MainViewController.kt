package com.yourssu.ssuwap

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController(appGraph: AppGraph) = ComposeUIViewController {
    with(appGraph) {
        SsuwapApp()
    }
}