plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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