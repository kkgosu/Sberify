package plugin

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
open class TestsSetup {
    /**
     * Implement dependencies for tests
     */
    var enabled: Boolean = false

    var junit: Boolean = true

    var truth: Boolean = true

    var mockito: Boolean = true

    var hamcrest: Boolean = false

    var androidXCore: Boolean = false
}