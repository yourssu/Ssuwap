package com.yourssu.ssuwap

import com.yourssu.imageselect.ImageLauncher
import com.yourssu.imageselect.ImageSelectGraph

interface AppGraph : ImageSelectGraph.Factory {
    val imageLauncher: ImageLauncher
}