import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies

/**
 * @author Konstantin Koval
 * @since 08.02.2021
 */

fun Project.hilt() {
    apply {
        plugin("com.android.library")
        plugin("org.jetbrains.kotlin.android")
        plugin("org.jetbrains.kotlin.kapt")
        plugin("dagger.hilt.android.plugin")
    }

    dependencies {
        hilt()
    }
}

private fun DependencyHandlerScope.hilt() {
    "implementation"(Libs.HILT_ANDROID)
    "implementation"(Libs.HILT_VIEWMODEL)
    "kapt"(Libs.HILT_COMPILER)
}

fun DependencyHandlerScope.room() {
    "implementation"(Libs.ROOM_COMMON)
    "implementation"(Libs.ROOM_KTX)
    "implementation"(Libs.ROOM_RUNTIME)
    "kapt"(Libs.ROOM_COMPILER)
}

fun LibraryExtension.commonAndroidConfig() {
    compileSdkVersion(BuildLibs.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(BuildLibs.MIN_SDK)
        targetSdkVersion(BuildLibs.TARGET_SDK)
        versionCode = BuildLibs.versionCodeMobile
        versionName = BuildLibs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}