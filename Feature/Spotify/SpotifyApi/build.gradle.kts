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
    api(project(Projects.CORE_DB))
    api(project(Projects.CORE_UTILS))
    api(project(Projects.SPOTIFY_COMMON))

    hilt()

    implementation(Libs.GSON)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.RETROFIT_GSON)
}