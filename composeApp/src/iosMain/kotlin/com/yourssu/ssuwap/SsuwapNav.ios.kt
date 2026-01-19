package com.yourssu.ssuwap

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yourssu.ssuwap.navigation.HomeRoute
import com.yourssu.ssuwap.navigation.extension.*

@Composable
context(appGraph: AppGraph)
actual fun SsuwapNav() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
    ) {
        homeScreen(
            onNavigateToImageSelect = navController::navigateToImageSelect,
        )
        cameraScreen(
            onPhotoCaptured = { uri ->
                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.set("camera_result_key", uri)
                navController.popBackStack()
            }
        )
        imageSelectScreen(
            onNavigateToCamera = navController::navigateToCamera,
            onNavigateToTransformResult = navController::navigateToTransformResult,
            navController = navController,
        )
        transformResultScreen()
    }
}