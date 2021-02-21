plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    commonAndroidConfig()
}

dependencies {
    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_PALETTE)
    implementation(Libs.LOTTIE)
    implementation(Libs.MATERIAL)
}