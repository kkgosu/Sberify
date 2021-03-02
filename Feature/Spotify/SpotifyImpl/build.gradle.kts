plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    commonAndroidConfig()
}

dependencies {
    api(project(Projects.SPOTIFY_API))

    hilt()
    room()

    implementation(Libs.GSON)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.RETROFIT_GSON)
}