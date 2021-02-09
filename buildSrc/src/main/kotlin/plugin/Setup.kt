package plugin

import org.gradle.api.Project

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
interface Setup {
    /**
     * Apply configuration to [project]
     */
    fun applyTo(project: Project)
}