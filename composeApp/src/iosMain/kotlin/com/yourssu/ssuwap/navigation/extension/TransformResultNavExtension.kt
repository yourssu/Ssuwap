package com.yourssu.ssuwap.navigation.extension

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yourssu.ssuwap.AppGraph
import com.yourssu.ssuwap.navigation.TransformResultRoute

fun NavController.navigateToTransformResult() {
    navigate(TransformResultRoute)
}

context(appGraph: AppGraph)
fun NavGraphBuilder.transformResultScreen(

) {
    composable<TransformResultRoute> {

    }
}