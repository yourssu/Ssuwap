package com.yourssu.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(KmpConventionPlugin::class.java)
                apply(KmpComposeConventionPlugin::class.java)
                apply(MetroConventionPlugin::class.java)
                apply("org.jetbrains.kotlin.plugin.serialization")
            }
        }
    }

}