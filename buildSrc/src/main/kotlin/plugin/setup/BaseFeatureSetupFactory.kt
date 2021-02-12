package plugin.setup

import org.gradle.api.Project
import plugin.SberifyExtension

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
abstract class BaseFeatureSetupFactory<E: SberifyExtension<F>, F: FeatureSetup> : SetupFactory<E> {

    override fun buildSetup(project: Project, extension: E): Setup {
        return EmptySetup()
    }
}