package com.yourssu.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.yourssu.convention.extension.kotlin
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

class KmpAndroidConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }
        }

        kotlin {
            androidTarget {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }
}