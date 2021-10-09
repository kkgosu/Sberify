import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildLibs.COMPILE_SDK
    defaultConfig {
        minSdk = BuildLibs.MIN_SDK
        targetSdk = BuildLibs.TARGET_SDK
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        configureEach {
            val authBasic = gradleLocalProperties(rootDir).getProperty("spotify_auth_basic")
            buildConfigField("String", "SPOTIFY_AUTH_BASIC", authBasic)
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
}

dependencies {
    api(project(Projects.SPOTIFY_API))

    hilt()
    room()

    implementation(Libs.GSON)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.RETROFIT_GSON)
}