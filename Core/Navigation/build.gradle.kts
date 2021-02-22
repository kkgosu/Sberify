plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    commonAndroidConfig()
}

dependencies {
    ui()

    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
}