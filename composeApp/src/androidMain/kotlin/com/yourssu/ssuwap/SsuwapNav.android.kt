package com.yourssu.ssuwap

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.yourssu.home.HomeScreen
import com.yourssu.ssuwap.navigation.CameraNavKey
import com.yourssu.ssuwap.navigation.HomeNavKey
import com.yourssu.ssuwap.navigation.ImageSelectNavKey
import com.yourssu.ssuwap.navigation.TransformLoadingNavKey
import com.yourssu.ssuwap.navigation.TransformResultNavKey

@Composable
context(appGraph: AppGraph)
actual fun SsuwapNav() {

    val backStack = rememberNavBackStack(HomeNavKey)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<HomeNavKey> {
                HomeScreen(
                    onNavigateToImageSelect = { backStack.add(ImageSelectNavKey) }
                )
            }
            entry<ImageSelectNavKey> {

            }
            entry<CameraNavKey> {

            }
            entry<TransformLoadingNavKey> {

            }
            entry<TransformResultNavKey> {

            }
        },
    )
}