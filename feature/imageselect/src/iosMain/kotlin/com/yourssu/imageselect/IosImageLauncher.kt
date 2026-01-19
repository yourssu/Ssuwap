package com.yourssu.imageselect

class IosImageLauncher : ImageLauncher {
    override fun launchGallery(onImageSelected: (String) -> Unit) {
        println("Open iOS Gallery")
        
        // 임시 테스트용 (빈 문자열 반환)
        // onImageSelected("file:///test/image.jpg")
    }
}