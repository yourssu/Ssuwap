package com.yourssu.ssuwap

import dev.zacsweers.metro.createGraphFactory

object IosAppEntryPoint {

    fun createGraph(): AppGraph {
        val factory = createGraphFactory<IosAppGraph.Factory>()

        return factory.createIosAppGraph()
    }
}