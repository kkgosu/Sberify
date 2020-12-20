object BuildLibs  {
    val versionName = "1.0.0"
    private val versionCodeBase = 100
    val versionCodeMobile = versionCodeBase + 3

    const val COMPILE_SDK = 30
    const val TARGET_SDK = 30
    const val MIN_SDK = 21

    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:4.1.1"
    const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21"
    const val NAVIGATION_SAVE_ARGS_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.1"
    const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
}
