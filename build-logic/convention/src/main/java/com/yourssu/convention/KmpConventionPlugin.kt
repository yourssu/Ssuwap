package com.yourssu.convention

import com.yourssu.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply(KmpAndroidConventionPlugin::class.java)
                apply(KmpIosConventionPlugin::class.java)
            }

            extensions.configure<KotlinMultiplatformExtension> {
                compilerOptions {
                    freeCompilerArgs.add("-Xcontext-parameters")
                }

                with(sourceSets) {
                    configureEach {
                        if (name == "commonMain") {
                            dependencies {
                                implementation(libs.findLibrary("soil.query.core").get())
                                implementation(libs.findLibrary("soil.query.compose").get())
                                implementation(libs.findLibrary("soil.form").get())
                                implementation(libs.findLibrary("soil.space").get())
                            }
                        }
                    }
                }
            }
        }
    }
}