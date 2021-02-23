plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    commonAndroidConfig()
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    hilt()
    ui()

    implementation(project(Projects.CORE_DB))
    implementation(project(Projects.CORE_UTILS))
    implementation(project(Projects.DESIGN_SYSTEM))
    implementation(project(Projects.LYRICS))
    implementation(project(Projects.SHARED))
    implementation(project(Projects.SPOTIFY_API))
    implementation(project(Projects.SPOTIFY_COMMON))

    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
}