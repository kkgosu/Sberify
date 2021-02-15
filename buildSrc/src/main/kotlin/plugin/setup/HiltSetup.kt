package plugin.setup

import Libs
import plugin.Configuration

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
class HiltSetup(
    private val viewModel: Boolean
) : Setup by MutableCompositeSetup(
    LibSetup(
        configuration = Configuration.IMPL,
        name = Libs.HILT_ANDROID
    ),
    LibSetup(
        configuration = Configuration.KAPT,
        name = Libs.HILT_COMPILER
    ),
    LibSetup(
        configuration = Configuration.KAPT,
        name = Libs.ANDROIDX_HILT_COMPILER
    ),
    if (viewModel) {
        LibSetup(
            configuration = Configuration.IMPL,
            name = Libs.HILT_VIEWMODEL
        )
    } else {
        EmptySetup()
    }
)