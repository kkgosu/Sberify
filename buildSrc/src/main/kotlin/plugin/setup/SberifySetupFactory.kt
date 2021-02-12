package plugin.setup

import org.gradle.api.Project
import plugin.SberifyExtension

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
class SberifySetupFactory<E: SberifyExtension<F>, F: FeatureSetup>(
    private val featureSetupFactory: BaseFeatureSetupFactory<E, F>
) : SetupFactory<E> {

    override fun buildSetup(project: Project, extension: E): Setup {
        return CompositeSetup(
            featureSetupFactory.buildSetup(project, extension)
        )
    }
}