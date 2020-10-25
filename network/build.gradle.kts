plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionCode = Versions.versionCodeMobile
        versionName = Versions.versionName

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
    api(platform(project(":versions")))
    api(project(":model"))

    kapt(platform(project(":versions")))
    kapt(Libs.HILT_COMPILER)
    kapt(Libs.ANDROIDX_HILT_COMPILER)

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_GSON)
    implementation(Libs.JSOUP)
    implementation(Libs.HILT_ANDROID)
    implementation(Libs.HILT_VIEWMODEL)
    implementation(Libs.PREFERENCES)
}