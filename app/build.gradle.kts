plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
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

    kotlinOptions {
        this.jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":spotify-app-remote"))

    implementation(Libs.ACTIVITY_KTX)
    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.ADAPTER_DELEGATES_VIEW_BINDING)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.CARDVIEW)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.CORE_KTX)
    implementation(Libs.COROUTINES)
    implementation(Libs.FRAGMENT_KTX)
    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_PALETTE)
    implementation(Libs.GSON)
    implementation(Libs.HILT_ANDROID)
    implementation(Libs.HILT_ANDROID)
    implementation(Libs.HILT_VIEWMODEL)
    implementation(Libs.HILT_VIEWMODEL)
    implementation(Libs.JSOUP)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Libs.LOTTIE)
    implementation(Libs.MATERIAL)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.PREFERENCES)
    implementation(Libs.PREFERENCES)
    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_GSON)
    implementation(Libs.ROOM_COMMON)
    implementation(Libs.ROOM_KTX)
    implementation(Libs.ROOM_RUNTIME)
    implementation(Libs.SPOTIFY_AUTH)
    implementation(Libs.TIMBER)

    kapt(Libs.ANDROIDX_HILT_COMPILER)
    kapt(Libs.ANDROIDX_HILT_COMPILER)
    kapt(Libs.HILT_COMPILER)
    kapt(Libs.HILT_COMPILER)
    kapt(Libs.ROOM_COMPILER)

    kaptAndroidTest(Libs.ANDROIDX_HILT_COMPILER)
    kaptAndroidTest(Libs.HILT_COMPILER)

    testImplementation(Libs.ARCH_TESTING)
    testImplementation(Libs.COROUTINES_TEST)
    testImplementation(Libs.HAMCREST)
    testImplementation(Libs.JUNIT)
    testImplementation(Libs.MOCKITO_CORE)
    testImplementation(Libs.MOCKITO_KOTLIN)
    testImplementation(Libs.ROOM_KTX)
    testImplementation(Libs.ROOM_RUNTIME)

    androidTestImplementation(Libs.ESPRESSO_CONTRIB)
    androidTestImplementation(Libs.ESPRESSO_CORE)
    androidTestImplementation(Libs.EXT_JUNIT)
}