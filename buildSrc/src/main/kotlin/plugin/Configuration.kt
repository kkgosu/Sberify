package plugin

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
enum class Configuration(
    val type: String
) {
    API("api"),
    IMPL("implementation"),
    KAPT("kapt"),
    TEST_IMPL("test_implementation")
}