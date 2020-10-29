package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.sberify.domain.IDatabaseRepository
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.album.AlbumEntity
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val database: AppDatabase
) : IDatabaseRepository {

    override fun loadFavoriteTracks(): LiveData<List<Track>> =
        liveData(Dispatchers.IO) {
            val data = database.getTrackDao().loadFavoriteTracks().map {
                it.map { trackEntity -> trackEntity.toTrack() }
            }
            emitSource(data)
        }

    override suspend fun updateAlbum(album: Album) {
        database.getAlbumDao().updateAlbum(AlbumEntity.from(album))
    }

    override fun loadFavoriteAlbums(): LiveData<List<Album>> =
        liveData(Dispatchers.IO) {
            val data = database.getAlbumDao().loadFavoriteTracks().map {
                it.map { albumEntity -> albumEntity.toAlbum() }
            }
            emitSource(data)
        }

}
