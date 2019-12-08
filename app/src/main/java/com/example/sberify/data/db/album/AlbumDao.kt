package com.example.sberify.data.db.album

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sberify.models.domain.Track

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlbum(albumEntity: AlbumEntity)

    @Query("SELECT * FROM albums ORDER BY release_date DESC")
    fun getAlbums(): LiveData<List<AlbumEntity>>

    @Query("SELECT * FROM albums WHERE name LIKE '%' || :key || '%' OR mname LIKE '%' || :key || '%'")
    fun getAlbumsByKeyword(key: String): LiveData<List<AlbumEntity>>

    @Query("SELECT * FROM albums WHERE spotify_id = :id")
    fun getAlbumById(id: String): LiveData<AlbumEntity>

    @Query("SELECT * FROM albums WHERE artist_id = :id")
    fun getAlbumsByArtistId(id: String): LiveData<List<AlbumEntity>>

    @Query("UPDATE albums SET track_ids =:tracks WHERE spotify_id =:id")
    suspend fun updateAlbumTracks(id: String, tracks: List<Track>)

    @Update(entity = AlbumEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAlbumTracks(albumEntity: AlbumEntity)
}