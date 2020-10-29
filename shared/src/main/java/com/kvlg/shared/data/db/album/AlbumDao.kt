package com.kvlg.shared.data.db.album

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kvlg.model.presentation.Track

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAlbum(albumEntity: AlbumEntity)

    @Query("SELECT * FROM albums ORDER BY release_date DESC LIMIT 50")
    fun getAlbums(): List<AlbumEntity>

    @Query("SELECT * FROM albums WHERE name LIKE '%' || :key || '%' OR mname LIKE '%' || :key || '%'")
    fun getAlbumsByKeyword(key: String): List<AlbumEntity>

    @Query("SELECT * FROM albums WHERE spotify_id = :id")
    fun getAlbumById(id: String): AlbumEntity

    @Query("SELECT * FROM albums WHERE artist_id = :id")
    fun getAlbumsByArtistId(id: String): LiveData<List<AlbumEntity>>

    @Query("UPDATE albums SET track_ids =:tracks WHERE spotify_id =:id")
    fun updateAlbumTracks(id: String, tracks: List<Track>)

    @Update(entity = AlbumEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAlbumTracks(albumEntity: AlbumEntity)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateAlbum(albumEntity: AlbumEntity)

    @Query("SELECT * FROM albums WHERE isFavorite = 1 ORDER BY name ASC")
    fun loadFavoriteAlbums(): List<AlbumEntity>
}