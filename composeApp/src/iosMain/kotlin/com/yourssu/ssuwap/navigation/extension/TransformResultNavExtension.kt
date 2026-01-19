package com.yourssu.ssuwap.navigation.extension

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.yourssu.ssuwap.AppGraph
import com.yourssu.ssuwap.navigation.TransformResultRoute

fun NavController.navigateToTransformResult(result: String) {
    navigate(TransformResultRoute(resultUri = result))
}

context(appGraph: AppGraph)
fun NavGraphBuilder.transformResultScreen(

) {
    composable<TransformResultRoute> { backStackEntry ->
        val route: TransformResultRoute = backStackEntry.toRoute()
        route.resultUri
    }
}