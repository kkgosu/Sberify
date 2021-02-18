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
    api(project(Projects.coreDb))
    api(project(Projects.coreUtils))
    api(project(Projects.spotifyCommon))

    hilt()

    implementation(Libs.GSON)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.RETROFIT_GSON)
}