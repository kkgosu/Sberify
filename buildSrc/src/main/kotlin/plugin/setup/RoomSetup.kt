package plugin.setup

import Libs
import plugin.Configuration

/**
 * @author Konstantin Koval
 * @since 15.02.2021
 */
class RoomSetup : Setup by CompositeSetup(
    LibSetup(
        configuration = Configuration.IMPL,
        name = Libs.ROOM_RUNTIME
    ),
    LibSetup(
        configuration = Configuration.IMPL,
        name = Libs.ROOM_COMMON
    ),
    LibSetup(
        configuration = Configuration.IMPL,
        name = Libs.ROOM_KTX
    ),
    LibSetup(
        configuration = Configuration.KAPT,
        name = Libs.ROOM_COMPILER
    ),
    AndroidSetup(
        defaultConfig = DefaultConfigSetup()
    )

) {
    companion object {
        const val ROOM_INCREMENTAL = "room.incremental"
    }
}