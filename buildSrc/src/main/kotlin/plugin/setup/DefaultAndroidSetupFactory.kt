package plugin.setup

import BuildLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import plugin.SberifyAndroidExtension

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
class DefaultAndroidSetupFactory<E : SberifyAndroidExtension> : SetupFactory<E> {
    override fun buildSetup(project: Project, extension: E): Setup {
        val java8Compatibility: Boolean = extension.java8Compatibility ?: true
        return AndroidSetup(
            compileSdkVersion = BuildLibs.COMPILE_SDK,
            defaultConfig = DefaultConfigSetup(
                targetSdkVersion = BuildLibs.TARGET_SDK,
                minSdkVersion = BuildLibs.MIN_SDK
            ),
            compileOptions = if (java8Compatibility) {
                CompileOptionsSetup(
                    sourceCompatibility = JavaVersion.VERSION_1_8,
                    targetCompatibility = JavaVersion.VERSION_1_8
                )
            } else {
                CompileOptionsSetup()
            }
        )
    }

}