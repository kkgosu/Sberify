/**
 * @author Konstantin Koval
 * @since 02.02.2021
 */
object Projects {
    private const val CORE = ":Core"
    private const val FEATURE = ":Feature"
    private const val SCREEN = ":Screen"

    private const val GENIUS = "Genius"
    private const val SPOTIFY = "Spotify"

    const val CORE_DB = "$CORE:CoreDb"
    const val CORE_UTILS = "$CORE:CoreUtils"
    const val DESIGN_SYSTEM = "$CORE:DesignSystem"
    const val SHARED = "$CORE:Shared"

    const val GENIUS_API = "$FEATURE:$GENIUS:GeniusApi"
    const val GENIUS_IMPL = "$FEATURE:$GENIUS:GeniusImpl"
    const val SPOTIFY_API = "$FEATURE:$SPOTIFY:SpotifyApi"
    const val SPOTIFY_IMPL = "$FEATURE:$SPOTIFY:SpotifyImpl"
    const val SPOTIFY_REMOTE = "$FEATURE:$SPOTIFY:spotify-app-remote"
    const val SPOTIFY_COMMON = "$FEATURE:$SPOTIFY:SpotifyCommon"
    const val SUGGESTION = "$FEATURE:Suggestion"

    const val ALBUM_DETAILS = "$SCREEN:AlbumDetails"
    const val FAVORITE = "$SCREEN:Favorite"
    const val LYRICS = "$SCREEN:Lyrics"
    const val NEW_RELEASES = "$SCREEN:NewReleases"
    const val SEARCH = "$SCREEN:Search"
}