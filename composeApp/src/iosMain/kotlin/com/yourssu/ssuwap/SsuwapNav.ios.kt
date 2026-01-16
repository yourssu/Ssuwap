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
            navController = navController
        )
        cameraScreen()
        imageSelectScreen()
        transformLoadingScreen()
        transformResultScreen()
    }
}