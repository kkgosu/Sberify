package com.example.sberify.data.db.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.kvlg.spotify_api.models.entity.AlbumEntity

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlbum(albumEntity: AlbumEntity)

    @Query("SELECT * FROM albums ORDER BY release_date DESC LIMIT 50")
    fun getAlbums(): LiveData<List<AlbumEntity>>

    @Query("UPDATE albums SET is_favorite = :isFavorite WHERE album_id = :id")
    suspend fun setAlbumIsFavorite(id: String, isFavorite: Boolean)

    @Query("SELECT * FROM albums WHERE is_favorite = 1 ORDER BY name ASC")
    fun loadFavoriteAlbums(): LiveData<List<AlbumEntity>>

    @Transaction
    @Query("SELECT * FROM albums WHERE album_id = :id")
    fun getAlbumInfo(id: String): LiveData<AlbumWithTracks>

    @Query("SELECT * FROM albums WHERE name LIKE '%' || :query || '%'")
    fun getAlbumsByQuery(query: String): LiveData<List<AlbumEntity>>

}