plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(BuildLibs.COMPILE_SDK)
    defaultConfig {
        applicationId = "com.example.sberify"
        minSdkVersion(BuildLibs.MIN_SDK)
        targetSdkVersion(BuildLibs.TARGET_SDK)
        versionCode = BuildLibs.versionCodeMobile
        versionName = BuildLibs.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            versionNameSuffix = "-debug"
        }
    }

    sourceSets {
        getByName("debug") {
            java.srcDir("src/debugRelease/java")
        }
        getByName("release") {
            java.srcDir("src/debugRelease/java")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    hilt()
    room()
    test()
    ui()

    implementation(project(Projects.coreDb))
    implementation(project(Projects.coreUtils))
    implementation(project(Projects.designSystem))
    implementation(project(Projects.spotify.api))
    implementation(project(Projects.spotify.impl))
    implementation(project(Projects.spotifyCommon))
    implementation(project(Projects.spotifyRemote))
    implementation(project(Projects.genius.api))
    implementation(project(Projects.genius.impl))
    implementation(project(Projects.suggestion))

    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.COROUTINES)
    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_PALETTE)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Libs.LOTTIE)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.RETROFIT)
    implementation(Libs.SPOTIFY_AUTH)

    kaptAndroidTest(Libs.ANDROIDX_HILT_COMPILER)
    kaptAndroidTest(Libs.HILT_COMPILER)

    androidTestImplementation(Libs.ESPRESSO_CONTRIB)
    androidTestImplementation(Libs.ESPRESSO_CORE)
    androidTestImplementation(Libs.EXT_JUNIT)
}