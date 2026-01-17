import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.ssuwap.android.application)
    alias(libs.plugins.ssuwap.kmp.ios)
    alias(libs.plugins.ssuwap.kmp.compose)
    alias(libs.plugins.metro)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.navigation3.ui)
            implementation(libs.androidx.navigation3.runtime)
        }
        commonMain.dependencies {
            implementation(projects.ssuwap.core.designsystem)
            implementation(projects.ssuwap.feature.home)
            implementation(projects.ssuwap.feature.camera)
            implementation(projects.ssuwap.feature.imageselect)
            implementation(projects.ssuwap.feature.transformloading)
            implementation(projects.ssuwap.feature.transformresult)

            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(libs.coil.compose)

            implementation(libs.kotlinx.serialization.json)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        iosMain.dependencies {
            implementation(libs.navigationCompose)
        }
    }

    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }

}

android {
    namespace = "com.yourssu.ssuwap"

    defaultConfig {
        applicationId = "com.yourssu.ssuwap"
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

