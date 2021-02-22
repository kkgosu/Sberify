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

    implementation(project(Projects.ALBUM_DETAILS))
    implementation(project(Projects.CORE_DB))
    implementation(project(Projects.CORE_UTILS))
    implementation(project(Projects.DESIGN_SYSTEM))
    implementation(project(Projects.FAVORITE))
    implementation(project(Projects.GENIUS_API))
    implementation(project(Projects.GENIUS_IMPL))
    implementation(project(Projects.LYRICS))
    implementation(project(Projects.MAIN))
    implementation(project(Projects.NEW_RELEASES))
    implementation(project(Projects.SPOTIFY_API))
    implementation(project(Projects.SPOTIFY_IMPL))
    implementation(project(Projects.SPOTIFY_COMMON))
    implementation(project(Projects.SPOTIFY_REMOTE))
    implementation(project(Projects.SUGGESTION))
    implementation(project(Projects.SEARCH))

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