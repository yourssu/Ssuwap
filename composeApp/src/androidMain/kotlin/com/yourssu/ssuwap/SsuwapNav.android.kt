package com.yourssu.ssuwap

import androidx.compose.runtime.Composable
import androidx.compose.runtime.retain.retain
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.yourssu.camera.CameraScreen
import com.yourssu.home.HomeScreen
import com.yourssu.imageselect.ImageSelectScreen
import com.yourssu.ssuwap.navigation.CameraNavKey
import com.yourssu.ssuwap.navigation.HomeNavKey
import com.yourssu.ssuwap.navigation.ImageSelectNavKey
import com.yourssu.ssuwap.navigation.TransformResultNavKey
import com.yourssu.transformresult.TransformResultScreen

@Composable
context(appGraph: AppGraph)
actual fun SsuwapNav() {

    val backStack = rememberNavBackStack(HomeNavKey)

    val imageSelectGraph = with(appGraph) {
        retain {
            appGraph.createImageSelectGraph()
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<HomeNavKey> {
                HomeScreen(
                    onNavigateToImageSelect = { backStack.add(ImageSelectNavKey()) }
                )
            }
            entry<ImageSelectNavKey> { key ->
                with(imageSelectGraph) {
                    ImageSelectScreen(
                        cameraResultUri = key.selectedUri,
                        onNavigateToCamera = { backStack.add(CameraNavKey) },
                        onNavigateToTransformResult = { uri ->
                            backStack[backStack.lastIndex] = TransformResultNavKey(uri)
                        }
                    )
                }
            }
            entry<CameraNavKey> {
                CameraScreen(
                    onPhotoCaptured = { uri ->
                        val imageSelectIndex = backStack.indexOfLast { it is ImageSelectNavKey }
                        if (imageSelectIndex != -1) {
                            backStack[imageSelectIndex] = ImageSelectNavKey(selectedUri = uri)
                        }
                        backStack.removeLastOrNull()
                    }
                )
            }
            entry<TransformResultNavKey> { key ->
                TransformResultScreen(
                    imageUri = key.resultUri,
                    onNavigateToHome = { backStack.removeLastOrNull() }
                )
            }
        },
    )
}