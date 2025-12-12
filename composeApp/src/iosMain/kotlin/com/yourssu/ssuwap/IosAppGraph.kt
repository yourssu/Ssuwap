package com.yourssu.ssuwap

import dev.zacsweers.metro.DependencyGraph

interface IosAppGraph : AppGraph {

    @DependencyGraph.Factory
    fun interface Factory {
        fun createIosAppGraph(): IosAppGraph
    }

}