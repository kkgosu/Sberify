package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import plugin.setup.PluginSetup
import plugin.setup.SetupFactory

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
class SberifyPlugin<E : SberifyExtension<*>>(
    private val extensionName: String,
    private val extensionClass: Class<E>,
    private val setupFactory: SetupFactory<E>
) : Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create(extensionName, extensionClass)
        PluginSetup(extension.defaultPlugin()).applyTo(target)
        extension.setEvaluatedHandler {
            setupFactory.buildSetup(target, extension).applyTo(target)
        }
    }
}