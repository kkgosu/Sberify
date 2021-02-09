package plugin

/**
 * @author Konstantin Koval
 * @since 09.02.2021
 */
open class SberifyAndroidLibExtension : SberifyAndroidExtension() {
    override fun defaultPlugin(): String = Plugins.ANDROID_LIB
}