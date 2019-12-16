package com.example.sberify.data.db.track

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks WHERE spotify_id = :id")
    fun getTrackById(id: String): LiveData<TrackEntity>

    @Query("SELECT * FROM tracks WHERE album_id = :id")
    fun getTracksByAlbumId(id: String): LiveData<List<TrackEntity>>

    @Query("SELECT * FROM tracks WHERE name LIKE '%' || :key || '%' OR artists LIKE '%' || :key || '%'")
    fun getTracksByKeyword(key: String): LiveData<List<TrackEntity>>

    @Query("UPDATE tracks SET lyrics = :lyrics WHERE spotify_id=:id")
    fun updateTrackLyrics(id: String, lyrics: String)

    @Query("SELECT * FROM tracks WHERE isFavorite = 1 ORDER BY name ASC")
    fun loadFavoriteTracks(): LiveData<List<TrackEntity>>

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTrack(trackEntity: TrackEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTrack(trackEntity: TrackEntity)
}