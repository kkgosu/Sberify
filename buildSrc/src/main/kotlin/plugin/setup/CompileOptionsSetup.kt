package plugin.setup

import org.gradle.api.JavaVersion

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
data class CompileOptionsSetup(
    val sourceCompatibility: JavaVersion? = null,
    val targetCompatibility: JavaVersion? = null
)