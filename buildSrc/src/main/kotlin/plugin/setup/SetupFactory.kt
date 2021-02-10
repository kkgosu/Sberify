package plugin.setup

import org.gradle.api.Project
import plugin.SberifyExtension

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
interface SetupFactory<E : SberifyExtension<*>> {
    /**
     * Create configuration [Setup] based on [project] and [extension]
     */
    fun buildSetup(project: Project, extension: E): Setup
}