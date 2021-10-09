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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    api(Libs.LOTTIE)
    api(Libs.GLIDE)

    implementation(Libs.ACTIVITY_KTX)
    implementation(Libs.CORE_KTX)
    implementation(Libs.MATERIAL)
}