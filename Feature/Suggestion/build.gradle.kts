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
    implementation(project(Projects.designSystem))

    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.ADAPTER_DELEGATES_VIEW_BINDING)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.CARDVIEW)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.MATERIAL)
    implementation(Libs.GSON)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.ROOM_COMMON)
}