plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    hilt()
    ui()

    implementation(project(Projects.ALBUM_DETAILS))
    implementation(project(Projects.CORE_UTILS))
    implementation(project(Projects.DESIGN_SYSTEM))
    implementation(project(Projects.LYRICS))
    implementation(project(Projects.SHARED))
    implementation(project(Projects.SPOTIFY_COMMON))
    implementation(project(Projects.SUGGESTION))

    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.FRAGMENT_KTX)
}