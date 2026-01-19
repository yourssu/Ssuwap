package com.yourssu.ssuwap.navigation.extension

import androidx.compose.runtime.retain.retain
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yourssu.imageselect.ImageSelectScreen
import com.yourssu.ssuwap.AppGraph
import com.yourssu.ssuwap.navigation.ImageSelectRoute

fun NavController.navigateToImageSelect() {
    navigate(ImageSelectRoute)
}

context(appGraph: AppGraph)
fun NavGraphBuilder.imageSelectScreen(
    onNavigateToCamera: () -> Unit,
    onNavigateToTransformResult: () -> Unit,
    navController: NavHostController,
) {
    composable<ImageSelectRoute> {
        val imageSelectGraph = with(appGraph) {
            retain {
                appGraph.createImageSelectGraph()
            }
        }
        val currentEntry = navController.currentBackStackEntryAsState()
        val cameraResult = currentEntry.value
            ?.savedStateHandle
            ?.get<String>("camera_result_key")
        with(imageSelectGraph) {
            ImageSelectScreen(
                onNavigateToCamera = onNavigateToCamera,
                onNavigateToTransformResult = onNavigateToTransformResult,
                cameraResult = cameraResult,
            )
        }
    }
}