package plugin

import Plugins
import plugin.setup.FeatureSetup

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
open class SberifyLibExtension : SberifyExtension<FeatureSetup>() {
    override var featuresSetup: FeatureSetup = FeatureSetup()

    override var kotlin: Boolean = true

    override fun defaultPlugin(): String = Plugins.KOTLIN
}