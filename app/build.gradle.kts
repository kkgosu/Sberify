import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}
//todo extract common settings
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

        configureEach {
            val appMetricaApiKey = gradleLocalProperties(rootDir).getProperty("app_metrica_api_key")
            buildConfigField("String", "APP_METRICA_API_KEY", appMetricaApiKey)
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
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    hilt()
    room()
    test()
    ui()

    implementation(project(Projects.ALBUM_DETAILS))
    implementation(project(Projects.ANALYTICS))
    implementation(project(Projects.CORE_DB))
    implementation(project(Projects.CORE_UTILS))
    implementation(project(Projects.DESIGN_SYSTEM))
    implementation(project(Projects.FAVORITE))
    implementation(project(Projects.GENIUS_API))
    implementation(project(Projects.GENIUS_IMPL))
    implementation(project(Projects.LYRICS))
    implementation(project(Projects.NEW_RELEASES))
    implementation(project(Projects.SPOTIFY_API))
    implementation(project(Projects.SPOTIFY_IMPL))
    implementation(project(Projects.SPOTIFY_COMMON))
    implementation(project(Projects.SPOTIFY_REMOTE))
    implementation(project(Projects.SUGGESTION))
    implementation(project(Projects.SEARCH))
    implementation(project(Projects.SHARED))

    implementation(Libs.APP_METRICA)
    implementation(Libs.COROUTINES)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.RETROFIT)
    implementation(Libs.SPOTIFY_AUTH)

    kaptAndroidTest(Libs.HILT_COMPILER)

    androidTestImplementation(Libs.ESPRESSO_CONTRIB)
    androidTestImplementation(Libs.ESPRESSO_CORE)
    androidTestImplementation(Libs.EXT_JUNIT)
}