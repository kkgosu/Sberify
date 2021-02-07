apply<AndroidLibPlugin>()

plugins {
    id("dagger.hilt.android.plugin")
}

dependencies {

    api(project(Projects.coreUtils))
    implementation(project(Projects.spotifyModels))

    implementation(Libs.HILT_ANDROID)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.ROOM_COMMON)
    implementation(Libs.ROOM_KTX)

    kapt(Libs.HILT_COMPILER)
    kapt(Libs.ROOM_COMPILER)
}