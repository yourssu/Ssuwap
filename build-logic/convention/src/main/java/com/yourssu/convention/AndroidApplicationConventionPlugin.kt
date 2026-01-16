package com.yourssu.convention

import com.android.build.api.dsl.ApplicationExtension
import com.yourssu.convention.extension.configureKotlinAndroid
import com.yourssu.convention.extension.findVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)

                defaultConfig{
                    targetSdk = findVersion("android.targetSdk").toInt()
                    versionCode = findVersion("versionCode").toInt()
                    versionName = findVersion("versionName")
                }

                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                    }
                }
            }
        }
    }
}