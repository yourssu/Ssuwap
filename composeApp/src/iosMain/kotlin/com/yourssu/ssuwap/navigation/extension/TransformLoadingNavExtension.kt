package com.yourssu.ssuwap.navigation.extension

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yourssu.ssuwap.AppGraph
import com.yourssu.ssuwap.navigation.TransformLoadingRoute

fun NavController.navigateToTransformLoading() {
    navigate(TransformLoadingRoute)
}

context(appGraph: AppGraph)
fun NavGraphBuilder.transformLoadingScreen(

) {
    composable<TransformLoadingRoute> {

    }
}