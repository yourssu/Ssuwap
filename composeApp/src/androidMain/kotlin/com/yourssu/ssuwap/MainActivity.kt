package com.yourssu.ssuwap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import com.yourssu.imageselect.AndroidImageLauncher

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        with(appGraph) {
            setContent {
                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.PickVisualMedia()
                ) { uri ->
                    (imageLauncher as? AndroidImageLauncher)?.onResult(uri)
                }

                LaunchedEffect(Unit) {
                    (imageLauncher as? AndroidImageLauncher)?.registerLauncher(launcher)
                }
                SsuwapApp()
            }
        }
    }
}