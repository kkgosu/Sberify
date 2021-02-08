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
    api(Libs.TIMBER)

    hilt()

    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_PALETTE)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LOTTIE)
    implementation(Libs.MATERIAL)
    implementation(Libs.PREFERENCES)
    implementation(Libs.RETROFIT)
}