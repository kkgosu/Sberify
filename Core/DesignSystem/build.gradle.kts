plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    commonAndroidConfig()
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Libs.CORE_KTX)
    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_PALETTE)
    implementation(Libs.LOTTIE)
    implementation(Libs.MATERIAL)
}