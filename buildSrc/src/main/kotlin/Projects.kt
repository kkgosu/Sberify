/**
 * @author Konstantin Koval
 * @since 02.02.2021
 */
object Projects {
    private const val CORE = "Core"
    private const val FEATURE = "Feature"

    val coreDb = makeSingleModulePath(CORE, "CoreDb", null)
    val coreUtils = makeSingleModulePath(CORE, "CoreUtils", null)

    val spotify = ApiImplModules(FEATURE, "Spotify")
    val spotifyRemote = makeSingleModulePath(FEATURE, "spotify-app-remote", "Spotify")
    val spotifyModels = makeSingleModulePath(FEATURE, "SpotifyModels", "Spotify")
    val genius = ApiImplModules(FEATURE, "Genius")

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