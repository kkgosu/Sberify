import com.yandex.metrica.YandexMetrica

internal class AnalyticsInteractorImpl : AnalyticsInteractor {

    override fun onNewReleasesOpen() {
        YandexMetrica.reportEvent(NEW_RELEASES_OPEN)
    }

    override fun onSearchOpen() {
        YandexMetrica.reportEvent(SEARCH_OPEN)
    }

    override fun onFavoriteOpen() {
        YandexMetrica.reportEvent(FAVORITE_OPEN)
    }

    override fun addFavoriteTrack() {
        YandexMetrica.reportEvent(ADD_FAVORITE_TRACK)
    }

    override fun addFavoriteAlbum() {
        YandexMetrica.reportEvent(ADD_FAVORITE_ALBUM)
    }

    private companion object {
        private const val NEW_RELEASES_OPEN = "New Realeases Open"
        private const val SEARCH_OPEN = "Search Open"
        private const val FAVORITE_OPEN = "Favorite Open"
        private const val ADD_FAVORITE_TRACK = "Favorite Track Add"
        private const val ADD_FAVORITE_ALBUM = "Favorite Album Add"
    }
}