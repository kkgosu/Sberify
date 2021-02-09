package plugin

import org.gradle.api.Project

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
class EmptySetupFactory<E : SberifyExtension<*>> : SetupFactory<E> {
    override fun buildSetup(project: Project, extension: E): Setup = EmptySetup()
}