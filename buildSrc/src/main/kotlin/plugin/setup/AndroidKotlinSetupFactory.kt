package plugin.setup

import Libs
import Plugins
import org.gradle.api.Project
import plugin.Configuration
import plugin.SberifyAndroidExtension

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
class AndroidKotlinSetupFactory<E: SberifyAndroidExtension> : SetupFactory<E> {
    override fun buildSetup(project: Project, extension: E): Setup {
        if (!extension.kotlinSetup.enabled) {
            return EmptySetup()
        }

        val setup = MutableCompositeSetup()
        setup += PluginSetup(Plugins.KOTLIN_ANDROID)
        setup += AndroidSetup()
        setup += LibSetup(configuration = Configuration.IMPL, name = Libs.KOTLIN_STDLIB)

        return setup
    }

}