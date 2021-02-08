hilt()

android {
    commonAndroidConfig()
}

dependencies {

    api(project(Projects.coreUtils))
    implementation(project(Projects.spotifyModels))

    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.ROOM_COMMON)
    implementation(Libs.ROOM_KTX)

    kapt(Libs.ROOM_COMPILER)
}