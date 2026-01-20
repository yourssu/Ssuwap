import java.util.Properties

plugins {
    alias(libs.plugins.ssuwap.kmp.feature)
    alias(libs.plugins.buildConfig)
}

android.namespace = "com.yourssu.imageselect"

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) load(file.inputStream())
}

val geminiKey = localProperties.getProperty("GEMINI_API_KEY") ?: ""

buildConfig {
    buildConfigField("String", "GEMINI_API_KEY", "\"$geminiKey\"")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.androidx.runtime.retain)
            implementation(libs.generativeai.google)

            implementation(libs.coil.compose)
        }

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
        }
    }
}