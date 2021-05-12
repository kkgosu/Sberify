/**
 * @author Konstantin Koval
 * @since 13.05.2021
 */
interface AnalyticsInteractor {

    fun onNewReleasesOpen()

    fun onSearchOpen()

    fun onFavoriteOpen()

    fun addFavoriteTrack()

    fun addFavoriteAlbum()

}