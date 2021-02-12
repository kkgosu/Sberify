package plugin.setup

import org.gradle.api.Project

/**
 * @author Konstantin Koval
 * @since 12.02.2021
 */
class MutableCompositeSetup(
    val setupsList: MutableList<Setup> = mutableListOf()
) : Setup {

    constructor(
        vararg setups: Setup
    ) : this(setups.toMutableList())

    override fun applyTo(project: Project) = setupsList.forEach { it.applyTo(project) }

    fun add(setup: Setup) {
        setupsList.add(setup)
    }

    operator fun plusAssign(setup: Setup) = add(setup)
}