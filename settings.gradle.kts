rootProject.name = "Ssuwap"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {

    includeBuild("build-logic")

    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()

        // Kotlin Dev 이후 2.3.20 정규 베타 나오면 삭제
        maven("https://packages.jetbrains.team/maven/p/kt/dev/")
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()

        // Kotlin Dev 이후 2.3.20 정규 베타 나오면 삭제
        maven("https://packages.jetbrains.team/maven/p/kt/dev/")
    }
}

include(":composeApp")
include(":feature:home")
include(":feature:imageselect")
include(":feature:camera")
include(":feature:transformloading")
include(":feature:transformresult")
include(":core:designsystem")
