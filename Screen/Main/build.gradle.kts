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
    implementation(project(Projects.GENIUS_API))
    implementation(project(Projects.SPOTIFY_API))
    implementation(project(Projects.SPOTIFY_COMMON))
    implementation(project(Projects.SPOTIFY_REMOTE))
    implementation(project(Projects.SUGGESTION))

    implementation(Libs.COROUTINES)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.MATERIAL)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.SPOTIFY_AUTH)
}