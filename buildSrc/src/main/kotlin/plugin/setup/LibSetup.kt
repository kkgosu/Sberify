package plugin.setup

import org.gradle.api.Project
import plugin.Configuration

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
class LibSetup(
    configuration: Configuration,
    val names: List<String>
) : DependencySetup(configuration) {

    constructor(
        configuration: Configuration,
        name: String
    ) : this(configuration, listOf(name))

    override fun dependencyNotations(project: Project): List<Any> = names
}