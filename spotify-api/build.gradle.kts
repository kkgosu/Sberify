plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(BuildLibs.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(BuildLibs.MIN_SDK)
        targetSdkVersion(BuildLibs.TARGET_SDK)
        versionCode = BuildLibs.versionCodeMobile
        versionName = BuildLibs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
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
    api(project(":core-db"))
    api(project(":core-utils"))
    api(project(":spotify-models"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.GSON)
    implementation(Libs.HILT_ANDROID)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.RETROFIT_GSON)
    implementation(Libs.ROOM_COMMON)
    implementation(Libs.ROOM_KTX)

    kapt(Libs.HILT_COMPILER)
    kapt(Libs.ROOM_COMPILER)
}