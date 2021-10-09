plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = BuildLibs.COMPILE_SDK
    defaultConfig {
        minSdk = BuildLibs.MIN_SDK
        targetSdk = BuildLibs.TARGET_SDK
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
}

dependencies {
    api(project(Projects.CORE_UTILS))
    api(project(Projects.SPOTIFY_API))

    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
}