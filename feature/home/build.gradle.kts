plugins {
    alias(libs.plugins.ssuwap.kmp.feature)
}

android.namespace = "com.yourssu.home"

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.androidx.runtime.retain)
        }
    }
}