plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
}

android {
    commonAndroidConfig()
}

dependencies {
    implementation(Libs.GSON)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.ROOM_COMMON)
}