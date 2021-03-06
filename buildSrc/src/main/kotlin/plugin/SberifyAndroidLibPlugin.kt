package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
class SberifyAndroidLibPlugin : Plugin<Project> by SberifyAndroidPlugin(
    extensionName = "sberify",
    extensionClass = SberifyAndroidLibExtension::class.java
)