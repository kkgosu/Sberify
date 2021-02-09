package plugin

import groovy.lang.Closure

/**
 * Base configurator which allows to turn on/off some features that can be grouped
 *
 * @author Konstantin Koval
 * @since 09.02.2021
 */
class AndroidFeaturesSetup : FeatureSetup() {

    val hiltOptions: HiltOptions = HiltOptions()

    val roomOptions: Options = Options()

    /**
     * Apply Hilt
     */
    var hilt: Boolean
        get() = hiltOptions.enabled
        set(value) {
            hiltOptions.enabled = value
        }

    /**
     * Apply Room
     */
    var room: Boolean
        get() = roomOptions.enabled
        set(value) {
            roomOptions.enabled = value
        }

    /**
     * Setup Hilt with [closure]
     */
    fun hilt(closure: Closure<HiltOptions>) = byClosure(hiltOptions, closure)

    /**
     * Setup Room with [closure]
     */
    fun room(closure: Closure<Options>) = byClosure(roomOptions, closure)

    private fun byClosure(options: Options, closure: Closure<*>) {
        options.enabled = true
        closure.delegate = options
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.call(options)
    }
}