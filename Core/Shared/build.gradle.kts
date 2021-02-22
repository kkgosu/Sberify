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

    implementation(project(Projects.CORE_DB))
    implementation(project(Projects.GENIUS_API))
    implementation(project(Projects.SPOTIFY_API))
    implementation(project(Projects.SPOTIFY_COMMON))
    implementation(project(Projects.SUGGESTION))

    implementation(Libs.COROUTINES)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)
}