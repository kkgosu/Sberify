plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    /**
     * @author Konstantin Koval
     * @since 08.02.2021
     */
    compileSdkVersion(BuildLibs.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(BuildLibs.MIN_SDK)
        targetSdkVersion(BuildLibs.TARGET_SDK)
        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        if (false) {
            javaCompileOptions {
                annotationProcessorOptions {
                    arguments["room.incremental"] = "true"
                }
            }
        }
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
    test()

    implementation(project(Projects.ANALYTICS))
    implementation(project(Projects.CORE_DB))
    implementation(project(Projects.CORE_UTILS))
    implementation(project(Projects.DESIGN_SYSTEM))
    implementation(project(Projects.GENIUS_API))
    implementation(project(Projects.SHARED))
    testImplementation(project(Projects.SHARED))
    implementation(project(Projects.SPOTIFY_COMMON))

    implementation(Libs.COROUTINES)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
}