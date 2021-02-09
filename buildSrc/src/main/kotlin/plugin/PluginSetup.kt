package plugin

import org.gradle.api.Project

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
class PluginSetup(
    vararg val name: String
) : Setup {
    override fun applyTo(project: Project) {
        name.forEach { project.pluginManager.apply(it) }
    }
}