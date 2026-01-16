package com.yourssu.convention

import com.yourssu.convention.extension.findPluginId
import org.gradle.api.Plugin
import org.gradle.api.Project

class MetroConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(findPluginId("metro"))
        }
    }
}