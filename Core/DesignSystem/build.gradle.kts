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
    api(Libs.LOTTIE)
    api(Libs.GLIDE)

    implementation(Libs.ACTIVITY_KTX)
    implementation(Libs.CORE_KTX)
    implementation(Libs.GLIDE_PALETTE)
    implementation(Libs.MATERIAL)
}