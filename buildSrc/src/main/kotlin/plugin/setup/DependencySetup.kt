package plugin.setup

import org.gradle.api.Project
import plugin.Configuration

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
abstract class DependencySetup(
    val configuration: Configuration
) : Setup {
    final override fun applyTo(project: Project) {
        dependencyNotations(project).forEach { project.dependencies.add(configuration.type, it) }
    }

    abstract fun dependencyNotations(project: Project): List<Any>
}