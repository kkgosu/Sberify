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

    api(project(Projects.genius.api))

    hilt()

    implementation(Libs.GSON)
    implementation(Libs.JSOUP)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.RETROFIT_GSON)
    implementation(Libs.ROOM_RUNTIME)
}