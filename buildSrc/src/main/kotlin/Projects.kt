/**
 * @author Konstantin Koval
 * @since 02.02.2021
 */
object Projects {
    private const val CORE = "Core"
    private const val FEATURE = "Feature"

    val coreDb = makeSingleModulePath(CORE, "CoreDb", null)
    val coreUtils = makeSingleModulePath(CORE, "CoreUtils", null)
    val designSystem = makeSingleModulePath(CORE, "DesignSystem", null)

    val genius = ApiImplModules(FEATURE, "Genius")
    val spotify = ApiImplModules(FEATURE, "Spotify")
    val spotifyRemote = makeSingleModulePath(FEATURE, "spotify-app-remote", "Spotify")
    val spotifyCommon = makeSingleModulePath(FEATURE, "SpotifyCommon", "Spotify")
    val suggestion = makeSingleModulePath(FEATURE, "Suggestion", null)

    class ApiImplModules(topLevelDirectory: String, relativePath: String) {
        private val path: String = ":$topLevelDirectory:$relativePath"

        val api = "$path:${relativePath}Api"
        val impl = "$path:${relativePath}Impl"
    }

    private fun makeSingleModulePath(topLevelDirectory: String, name: String, relativePath: String?): String {
        return if (relativePath != null) {
            ":$topLevelDirectory:$relativePath:$name"
        } else {
            ":$topLevelDirectory:$name"
        }
    }
}