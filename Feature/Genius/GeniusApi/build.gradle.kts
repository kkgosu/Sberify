plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    commonAndroidConfig()
}

dependencies {
    api(project(Projects.coreUtils))
    api(project(Projects.spotify.api))

    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
}