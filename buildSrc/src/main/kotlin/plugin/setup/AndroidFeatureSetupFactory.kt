package plugin.setup

import org.gradle.api.Project
import plugin.SberifyAndroidExtension

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
class AndroidFeatureSetupFactory<E : SberifyAndroidExtension> : BaseFeatureSetupFactory<E, AndroidFeaturesSetup>() {
    override fun buildSetup(project: Project, extension: E): Setup {
        val setups = MutableCompositeSetup(super.buildSetup(project, extension))
        val featureConfig = extension.featuresSetup

        if (featureConfig.hiltOptions.enabled) {
            setups += HiltSetup(featureConfig.hiltOptions.viewModel)
        }

        if (featureConfig.roomOptions.enabled) {
            setups += RoomSetup()
        }

        return setups
    }
}