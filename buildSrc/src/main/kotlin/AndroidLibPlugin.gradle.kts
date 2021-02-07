import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.plugins.LibraryPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies

class AndroidLibPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.pluginManager.apply("com.android.library")
        project.pluginManager.apply("kotlin-android")
        project.pluginManager.apply("kotlin-kapt")

        project.extensions.create<LibraryExtension>("123")
        val androidExtension = project.plugins.findPlugin(LibraryPlugin::class.java)?.extension as? LibraryExtension
        androidExtension?.run {
            commonAndroidConfig()
        }

        project.dependencies {
            implementation(Libs.TIMBER)
        }
    }

    private fun LibraryExtension.commonAndroidConfig() {
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

    private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
        add("implementation", dependencyNotation)
}