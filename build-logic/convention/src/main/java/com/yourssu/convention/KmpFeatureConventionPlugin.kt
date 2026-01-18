package com.yourssu.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(KmpConventionPlugin::class.java)
                apply(KmpComposeConventionPlugin::class.java)
                apply(MetroConventionPlugin::class.java)
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                sourceSets.apply {
                    commonMain {
                        dependencies {
                            implementation(project(":core:designsystem"))
                        }
                    }
                }
            }
        }
    }

}