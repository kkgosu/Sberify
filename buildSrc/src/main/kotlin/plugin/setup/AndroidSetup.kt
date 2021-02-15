package plugin.setup

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import plugin.apply

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
class AndroidSetup(
    val compileSdkVersion: Int? = null,
    val defaultConfig: DefaultConfigSetup = DefaultConfigSetup(),
    val compileOptions: CompileOptionsSetup = CompileOptionsSetup()
) : Setup {
    override fun applyTo(project: Project) {
        val libraryExt = project.extensions.getByType(BaseExtension::class.java)
        compileSdkVersion?.let(libraryExt::compileSdkVersion)
        libraryExt.defaultConfig.apply(defaultConfig)
        libraryExt.compileOptions.apply(compileOptions)
    }
}