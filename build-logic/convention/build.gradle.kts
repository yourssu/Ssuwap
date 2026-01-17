import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.yourssu.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    implementation(libs.bundles.plugins)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.ssuwap.android.application.get().pluginId
            implementationClass = "com.yourssu.convention.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.ssuwap.android.library.get().pluginId
            implementationClass = "com.yourssu.convention.AndroidLibraryConventionPlugin"
        }
        register("kmpAndroid") {
            id = libs.plugins.ssuwap.kmp.android.get().pluginId
            implementationClass = "com.yourssu.convention.KmpAndroidConventionPlugin"
        }
        register("kmpIos") {
            id = libs.plugins.ssuwap.kmp.ios.get().pluginId
            implementationClass = "com.yourssu.convention.KmpIosConventionPlugin"
        }
        register("kmp") {
            id = libs.plugins.ssuwap.kmp.asProvider().get().pluginId
            implementationClass = "com.yourssu.convention.KmpConventionPlugin"
        }
        register("kmpCompose") {
            id = libs.plugins.ssuwap.kmp.compose.get().pluginId
            implementationClass = "com.yourssu.convention.KmpComposeConventionPlugin"
        }
        register("kmpFeature") {
            id = libs.plugins.ssuwap.kmp.feature.get().pluginId
            implementationClass = "com.yourssu.convention.KmpFeatureConventionPlugin"
        }
        register("metro") {
            id = libs.plugins.ssuwap.metro.get().pluginId
            implementationClass = "com.yourssu.convention.MetroConventionPlugin"
        }
    }
}