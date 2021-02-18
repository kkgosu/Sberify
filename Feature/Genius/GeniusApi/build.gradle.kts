plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    commonAndroidConfig()
}

dependencies {
    api(project(Projects.CORE_UTILS))
    api(project(Projects.SPOTIFY_API))

    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
}