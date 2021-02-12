package plugin.setup

import Plugins
import org.gradle.api.Project
import plugin.SberifyLibExtension

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
object KotlinSetupFactory : SetupFactory<SberifyLibExtension> {
    override fun buildSetup(project: Project, extension: SberifyLibExtension): Setup {
        return if (extension.kotlin) {
            CompositeSetup(
                PluginSetup(Plugins.KOTLIN)
            )
        } else {
            EmptySetup()
        }
    }
}