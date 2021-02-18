plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    commonAndroidConfig(withRoom = true)
}

dependencies {
    api(project(Projects.coreUtils))

    hilt()
    room()

    implementation(project(Projects.spotifyModels))
    implementation(project(Projects.suggestion))

    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
}