package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
class SberifyAndroidPlugin<E : SberifyAndroidExtension>(
    extensionName: String,
    extensionClass: Class<E>,
    setupFactory: SetupFactory<E>
) : Plugin<Project> by SberifyPlugin(
    extensionName, extensionClass, setupFactory
)