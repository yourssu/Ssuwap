package com.yourssu.ssuwap.navigation.extension

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yourssu.ssuwap.AppGraph
import com.yourssu.ssuwap.navigation.CameraRoute

fun NavController.navigateToCamera() {
    navigate(CameraRoute)
}

context(appGraph: AppGraph)
fun NavGraphBuilder.cameraScreen(

) {
    composable<CameraRoute> {

    }
}