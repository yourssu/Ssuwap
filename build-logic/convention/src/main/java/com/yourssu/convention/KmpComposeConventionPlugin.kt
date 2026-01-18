package com.yourssu.convention

import com.yourssu.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.compose")
            pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

            extensions.configure<KotlinMultiplatformExtension> {
                val compose = extensions.getByType(ComposePlugin.Dependencies::class.java)

                with(sourceSets) {
                    configureEach {
                        if (name == "commonMain") {
                            dependencies {
                                implementation(compose.runtime)
                                implementation(compose.foundation)
                                implementation(compose.materialIconsExtended)
                                implementation(compose.material3)
                                implementation(compose.ui)
                                implementation(compose.components.resources)
                                implementation(compose.components.uiToolingPreview)

                                implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                                implementation(libs.findLibrary("androidx.runtime.retain").get())
                            }
                        }

                        if (name == "androidMain") {
                            dependencies {
                                implementation(compose.preview)
                            }
                        }
                    }
                }
            }
        }
    }
}