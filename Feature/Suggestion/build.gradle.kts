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
    implementation(project(Projects.DESIGN_SYSTEM))

    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.ADAPTER_DELEGATES_VIEW_BINDING)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.MATERIAL)
}