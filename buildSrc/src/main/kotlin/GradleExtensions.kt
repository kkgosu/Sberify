import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * @author Konstantin Koval
 * @since 08.02.2021
 */

/*fun LibraryExtension.commonAndroidConfig(withRoom: Boolean = false) {
    compileSdkVersion(BuildLibs.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(BuildLibs.MIN_SDK)
        targetSdkVersion(BuildLibs.TARGET_SDK)
        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
}*/

fun DependencyHandlerScope.hilt() {
    impl(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)
    kapt("com.google.dagger:hilt-compiler:2.38.1")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
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