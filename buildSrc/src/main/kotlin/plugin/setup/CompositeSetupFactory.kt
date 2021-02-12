package plugin.setup

import org.gradle.api.Project
import plugin.SberifyExtension

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
class CompositeSetupFactory<E : SberifyExtension<*>>(
    private vararg val setupFactories: SetupFactory<E>
) : SetupFactory<E> {
    override fun buildSetup(project: Project, extension: E): Setup {
        val setups = MutableCompositeSetup()

        setupFactories.forEach {
            setups += it.buildSetup(project, extension)
        }

        return setups
    }
}