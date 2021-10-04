plugins {
    id("com.android.library")
    kotlin("android")
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
    api(Libs.LOTTIE)
    api(Libs.GLIDE)

    implementation(Libs.ACTIVITY_KTX)
    implementation(Libs.CORE_KTX)
    implementation(Libs.GLIDE_PALETTE)
    implementation(Libs.MATERIAL)
}