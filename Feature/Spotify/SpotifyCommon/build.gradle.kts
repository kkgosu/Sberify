plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
}

android {
    commonAndroidConfig()
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(Projects.DESIGN_SYSTEM))

    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.ADAPTER_DELEGATES_VIEW_BINDING)
    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_PALETTE)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.CARDVIEW)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.MATERIAL)
    implementation(Libs.GSON)
    implementation(Libs.ROOM_COMMON)
}