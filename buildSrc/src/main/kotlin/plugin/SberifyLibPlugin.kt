package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import plugin.setup.CompositeSetupFactory
import plugin.setup.DefaultLibSetupFactory
import plugin.setup.FeatureSetupFactory
import plugin.setup.KotlinSetupFactory
import plugin.setup.SberifySetupFactory

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
class SberifyLibPlugin : Plugin<Project> by SberifyPlugin(
    extensionName = "sberify",
    extensionClass = SberifyLibExtension::class.java,
    setupFactory = CompositeSetupFactory(
        KotlinSetupFactory,
        DefaultLibSetupFactory,
        SberifySetupFactory(FeatureSetupFactory)
    )
)