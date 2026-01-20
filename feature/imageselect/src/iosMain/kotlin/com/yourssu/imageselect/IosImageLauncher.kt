package com.yourssu.imageselect

import platform.UIKit.UIApplication
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerSourceType
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.darwin.NSObject
import platform.Foundation.NSURL
import platform.UIKit.UIImagePickerControllerImageURL
import platform.UIKit.UIWindow

class IosImageLauncher : ImageLauncher {
    private val delegate = ImagePickerDelegate()

    override fun launchGallery(onImageSelected: (String) -> Unit) {
        val controller = UIImagePickerController()
        controller.sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypePhotoLibrary

        // 델리게이트 설정
        delegate.onImageSelected = onImageSelected
        controller.delegate = delegate

        val window = UIApplication.sharedApplication.windows.firstOrNull {
            (it as? UIWindow)?.isKeyWindow() == true
        } as? UIWindow

        val rootViewController = window?.rootViewController

        if (rootViewController != null) {
            rootViewController.presentViewController(controller, animated = true, completion = null)
        } else {
            println("Error: Cannot find rootViewController to present Gallery")
        }
    }

    private class ImagePickerDelegate : NSObject(),
        UIImagePickerControllerDelegateProtocol,
        UINavigationControllerDelegateProtocol {

        var onImageSelected: ((String) -> Unit)? = null

        override fun imagePickerController(
            picker: UIImagePickerController,
            didFinishPickingMediaWithInfo: Map<Any?, *>
        ) {
            val imageUrl = didFinishPickingMediaWithInfo[UIImagePickerControllerImageURL] as? NSURL
            val uriString = imageUrl?.absoluteString

            if (uriString != null) {
                onImageSelected?.invoke(uriString)
            }

            picker.dismissViewControllerAnimated(true, completion = null)
        }

        override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
            picker.dismissViewControllerAnimated(true, completion = null)
        }
    }
}