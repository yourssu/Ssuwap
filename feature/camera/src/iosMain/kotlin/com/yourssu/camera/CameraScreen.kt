package com.yourssu.camera

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.*
import platform.Foundation.NSTemporaryDirectory
import platform.Foundation.NSURL
import platform.Foundation.writeToURL
import platform.UIKit.UIColor
import platform.UIKit.UIView
import platform.darwin.NSObject
import platform.darwin.dispatch_get_global_queue

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun CameraScreen(
    onPhotoCaptured: (String) -> Unit,
    modifier: Modifier,
) {
    val device = AVCaptureDevice.defaultDeviceWithMediaType(AVMediaTypeVideo)
    val input = device?.let { AVCaptureDeviceInput.deviceInputWithDevice(it, null) }
    val output = remember { AVCapturePhotoOutput() }
    val session = remember { AVCaptureSession() }

    remember(device, input) {
        if (device != null && input != null) {
            session.beginConfiguration()
            if (session.canAddInput(input)) {
                session.addInput(input)
            }
            if (session.canAddOutput(output)) {
                session.addOutput(output)
            }
            session.commitConfiguration()
        }
    }

    DisposableEffect(Unit) {
        val queue = dispatch_get_global_queue(0, 0u)
        platform.darwin.dispatch_async(queue) {
            session.startRunning()
        }
        onDispose {
            session.stopRunning()
        }
    }

    val photoDelegate = remember {
        object : NSObject(), AVCapturePhotoCaptureDelegateProtocol {
            override fun captureOutput(
                output: AVCapturePhotoOutput,
                didFinishProcessingPhoto: AVCapturePhoto,
                error: platform.Foundation.NSError?
            ) {
                val fileData = didFinishProcessingPhoto.fileDataRepresentation()
                if (fileData != null) {
                    val fileName = "${platform.Foundation.NSUUID().UUIDString}.jpg"
                    val url = NSURL.fileURLWithPath(NSTemporaryDirectory()).URLByAppendingPathComponent(fileName)

                    if (url != null) {
                        fileData.writeToURL(url, true)
                        onPhotoCaptured(url.absoluteString ?: "")
                    }
                }
            }
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        UIKitView(
            factory = {
                val container = UIView()
                container.backgroundColor = UIColor.blackColor

                val previewLayer = AVCaptureVideoPreviewLayer(session = session)
                previewLayer.videoGravity = AVLayerVideoGravityResizeAspectFill

                previewLayer.frame = container.bounds
                container.layer.addSublayer(previewLayer)

                container
            },
            update = { view ->
                view.layer.sublayers?.firstOrNull()?.let { layer ->
                    (layer as AVCaptureVideoPreviewLayer).frame = view.bounds
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        FloatingActionButton(
            onClick = {
                val settings = AVCapturePhotoSettings.photoSettings()
                output.capturePhotoWithSettings(settings, photoDelegate)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(32.dp)
                .size(72.dp),
            containerColor = Color.White,
            contentColor = Color.Black
        ) {
            Icon(
                imageVector = Icons.Default.Camera,
                contentDescription = "Take photo",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}