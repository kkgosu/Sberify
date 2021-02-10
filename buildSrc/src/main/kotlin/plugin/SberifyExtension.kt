package plugin

import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.util.Configurable
import plugin.setup.FeatureSetup
import plugin.setup.TestsSetup

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
abstract class SberifyExtension<F : FeatureSetup> : Configurable<SberifyExtension<F>> {

    /**
     * Handler for event "we have been configured"
     */
    private var onEvaluatedHandler: ((SberifyExtension<F>) -> Unit)? = null

    /**
     * sourceCompatibility
     */
    var java8Compatibility: Boolean? = null

    /**
     * Configuration for tests
     */
    val testsSetup: TestsSetup = TestsSetup()

    var tests: Boolean
        get() = testsSetup.enabled
        set(value) {
            testsSetup.enabled = value
        }

    abstract var kotlin: Boolean

    /**
     * Configuration of connected features
     */
    abstract var featuresSetup: F

    /**
     * Connect features to module
     */
    fun features(action: Action<F>) = action.execute(featuresSetup)

    fun tests(action: Action<TestsSetup>) {
        testsSetup.enabled = true
        action.execute(testsSetup)
    }

    /**
     * Main plugin for module
     */
    abstract fun defaultPlugin(): String

    /**
     * Set handler for finishing configuration
     */
    fun setEvaluatedHandler(handler: (SberifyExtension<F>) -> Unit) {
        onEvaluatedHandler = handler
    }

    override fun configure(cl: Closure<*>): SberifyExtension<F> {
        cl.resolveStrategy = Closure.DELEGATE_FIRST
        cl.delegate = this
        cl.call()
        onEvaluatedHandler?.invoke(this)
        return this
    }
}