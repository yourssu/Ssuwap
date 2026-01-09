package com.yourssu.ssuwap.navigation.extension

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yourssu.ssuwap.AppGraph
import com.yourssu.ssuwap.navigation.ImageSelectRoute

fun NavController.navigateToImageSelect() {
    navigate(ImageSelectRoute)
}

context(appGraph: AppGraph)
fun NavGraphBuilder.imageSelectScreen(

) {
    composable<ImageSelectRoute> {

    }
}