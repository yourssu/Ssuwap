package com.yourssu.ssuwap

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph

@DependencyGraph(AppScope::class)
interface IosAppGraph : AppGraph {

    @DependencyGraph.Factory
    fun interface Factory {
        fun createIosAppGraph(): IosAppGraph
    }

}