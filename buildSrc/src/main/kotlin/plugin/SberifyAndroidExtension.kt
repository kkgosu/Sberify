package plugin

import org.gradle.api.Action
import plugin.options.KotlinOptions
import plugin.setup.AndroidFeaturesSetup
import plugin.setup.TestsSetup

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
abstract class SberifyAndroidExtension : SberifyExtension<AndroidFeaturesSetup>() {

    final override var featuresSetup: AndroidFeaturesSetup = AndroidFeaturesSetup()

    val androidTestsSetup: TestsSetup = TestsSetup()

    var androidTests: Boolean
        get() = androidTestsSetup.enabled
        set(value) {
            androidTestsSetup.enabled = value
        }

    fun androidTests(closure: Action<TestsSetup>) {
        androidTestsSetup.enabled = true
        closure.execute(androidTestsSetup)
    }

    /**
     * Kotlin setup
     */
    val kotlinSetup: KotlinOptions = KotlinOptions()

    final override var kotlin: Boolean
        get() = kotlinSetup.enabled
        set(value) {
            kotlinSetup.enabled = value
        }

    fun kotlin(action: Action<KotlinOptions>) {
        kotlinSetup.enabled = true
        action.execute(kotlinSetup)
    }
}