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

    implementation(project(Projects.ALBUM_DETAILS))
    implementation(project(Projects.CORE_DB))
    implementation(project(Projects.CORE_UTILS))
    implementation(project(Projects.DESIGN_SYSTEM))
    implementation(project(Projects.NAVIGATION))
    implementation(project(Projects.SPOTIFY_API))
    implementation(project(Projects.SPOTIFY_COMMON))

    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.MATERIAL)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.SWIPE_REFRESH_LAYOUT)
}