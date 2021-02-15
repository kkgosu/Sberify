package plugin

import com.android.build.gradle.internal.CompileOptions
import com.android.build.gradle.internal.dsl.DefaultConfig
import plugin.setup.CompileOptionsSetup
import plugin.setup.DefaultConfigSetup

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
internal fun DefaultConfig.apply(defaultConfigSetup: DefaultConfigSetup) {
    defaultConfigSetup.targetSdkVersion?.let { targetSdkVersion(it) }
    defaultConfigSetup.minSdkVersion?.let { minSdkVersion(it) }
}

internal fun CompileOptions.apply(compileOptionsSetup: CompileOptionsSetup) {
    compileOptionsSetup.sourceCompatibility?.let { sourceCompatibility = it }
    compileOptionsSetup.targetCompatibility?.let { targetCompatibility = it }
}