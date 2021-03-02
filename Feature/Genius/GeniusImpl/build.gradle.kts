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

    api(project(Projects.GENIUS_API))

    hilt()

    implementation(Libs.GSON)
    implementation(Libs.JSOUP)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.RETROFIT_GSON)
    implementation(Libs.ROOM_RUNTIME)
}