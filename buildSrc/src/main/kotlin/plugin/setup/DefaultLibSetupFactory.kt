package plugin.setup

import org.gradle.api.Project
import plugin.SberifyLibExtension

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
object DefaultLibSetupFactory : SetupFactory<SberifyLibExtension> {

    override fun buildSetup(project: Project, extension: SberifyLibExtension): Setup {
        val java8Compatibility: Boolean = extension.java8Compatibility ?: true
        return if (java8Compatibility) {
            JavaCompatibilitySetup()
        } else {
            EmptySetup()
        }
    }
}