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
    api(project(Projects.CORE_UTILS))

    hilt()
    room()
    test()

    implementation(project(Projects.SPOTIFY_COMMON))
    implementation(project(Projects.SUGGESTION))

    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
}