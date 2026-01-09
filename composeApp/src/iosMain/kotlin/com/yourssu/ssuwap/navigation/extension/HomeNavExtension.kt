package com.yourssu.ssuwap.navigation.extension

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yourssu.ssuwap.AppGraph
import com.yourssu.ssuwap.navigation.HomeRoute

fun NavController.navigateToHome() {
    navigate(HomeRoute)
}

context(appGraph: AppGraph)
fun NavGraphBuilder.homeScreen(

) {
    composable<HomeRoute> {

    }
}