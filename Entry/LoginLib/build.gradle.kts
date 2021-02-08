plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    commonAndroidConfig()
}

dependencies {
    hilt()
    ui()
    test()

    implementation(project(Projects.coreUtils))
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.SPOTIFY_AUTH)
}