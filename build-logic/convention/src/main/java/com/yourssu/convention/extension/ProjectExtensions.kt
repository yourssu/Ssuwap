package com.yourssu.convention.extension

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.findVersion(alias: String): String =
    libs.findVersion(alias).get().requiredVersion

fun Project.findPluginId(alias: String): String =
    libs.findPlugin(alias).get().get().pluginId