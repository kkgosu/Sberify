import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * @author Konstantin Koval
 * @since 08.02.2021
 */

fun LibraryExtension.commonAndroidConfig(withRoom: Boolean = false) {
    compileSdkVersion(BuildLibs.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(BuildLibs.MIN_SDK)
        targetSdkVersion(BuildLibs.TARGET_SDK)
        versionCode = BuildLibs.versionCodeMobile
        versionName = BuildLibs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        if (withRoom) {
            javaCompileOptions {
                annotationProcessorOptions {
                    arguments["room.incremental"] = "true"
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

fun DependencyHandlerScope.hilt() {
    impl(Libs.HILT_ANDROID)
    impl(Libs.HILT_VIEWMODEL)
    kapt(Libs.HILT_COMPILER)
    kapt(Libs.ANDROIDX_HILT_COMPILER)
}

fun DependencyHandlerScope.room() {
    impl(Libs.ROOM_COMMON)
    impl(Libs.ROOM_KTX)
    impl(Libs.ROOM_RUNTIME)
    kapt(Libs.ROOM_COMPILER)
}

fun DependencyHandlerScope.ui() {
    impl(Libs.ACTIVITY_KTX)
    impl(Libs.APPCOMPAT)
    impl(Libs.CARDVIEW)
    impl(Libs.CONSTRAINT_LAYOUT)
    impl(Libs.CORE_KTX)
    impl(Libs.FRAGMENT_KTX)
    impl(Libs.MATERIAL)
}

fun DependencyHandlerScope.test() {
    testImpl(Libs.ARCH_TESTING)
    testImpl(Libs.COROUTINES_TEST)
    testImpl(Libs.HAMCREST)
    testImpl(Libs.JUNIT)
    testImpl(Libs.MOCKITO)
}

private fun DependencyHandlerScope.impl(lib: String) {
    "implementation"(lib)
}

private fun DependencyHandlerScope.kapt(lib: String) {
    "kapt"(lib)
}

private fun DependencyHandlerScope.testImpl(lib: String) {
    "testImplementation"(lib)
}