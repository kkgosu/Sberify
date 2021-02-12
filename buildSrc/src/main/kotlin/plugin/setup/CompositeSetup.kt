package plugin.setup

import org.gradle.api.Project

/**
 * Configuration which compose few setups
 *
 * @author Konstantin Koval
 * @since 12.02.2021
 */
class CompositeSetup(
    vararg val setups: Setup
) : Setup {
    override fun applyTo(project: Project) = setups.forEach { it.applyTo(project) }
}