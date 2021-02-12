package plugin.setup

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
class JavaCompatibilitySetup : Setup {
    override fun applyTo(project: Project) {
        val extension = project.extensions.getByType(JavaPluginExtension::class.java)
        extension.sourceCompatibility = JavaVersion.VERSION_1_8
        extension.targetCompatibility = JavaVersion.VERSION_1_8
    }
}