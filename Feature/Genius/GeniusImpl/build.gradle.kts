plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
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
}

dependencies {

    api(project(Projects.GENIUS_API))

    hilt()

    implementation(Libs.GSON)
    implementation(Libs.JSOUP)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.RETROFIT_GSON)
    implementation(Libs.ROOM_RUNTIME)
}