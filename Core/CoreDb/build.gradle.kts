plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildLibs.COMPILE_SDK
    defaultConfig {
        minSdk = BuildLibs.MIN_SDK
        targetSdk = BuildLibs.TARGET_SDK
        consumerProguardFiles("consumer-rules.pro")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
}

dependencies {
    api(project(Projects.CORE_UTILS))

    hilt()
    room()
    test()

    implementation(project(Projects.SPOTIFY_COMMON))
    implementation(project(Projects.SUGGESTION))

    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
}