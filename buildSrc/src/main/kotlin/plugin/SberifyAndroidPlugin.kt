package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import plugin.setup.AndroidFeatureSetupFactory
import plugin.setup.AndroidKotlinSetupFactory
import plugin.setup.CompositeSetupFactory
import plugin.setup.DefaultAndroidSetupFactory
import plugin.setup.EmptySetupFactory
import plugin.setup.SberifySetupFactory
import plugin.setup.SetupFactory

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
class SberifyAndroidPlugin<E : SberifyAndroidExtension>(
    extensionName: String,
    extensionClass: Class<E>,
    setupFactory: SetupFactory<E> = EmptySetupFactory()
) : Plugin<Project> by SberifyPlugin(
    extensionName = extensionName,
    extensionClass = extensionClass,
    setupFactory = CompositeSetupFactory(
        AndroidKotlinSetupFactory(),
        DefaultAndroidSetupFactory(),
        SberifySetupFactory(AndroidFeatureSetupFactory()),
        setupFactory
    )
)