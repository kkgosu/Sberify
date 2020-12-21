package com.example.sberify.data.db.track

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks WHERE track_id = :id")
    fun getTrackById(id: String): LiveData<TrackEntity>

    @Query("SELECT * FROM tracks WHERE name LIKE '%' || :query || '%'")
    fun getTracksByQuery(query: String): LiveData<List<TrackEntity>>

    @Query("UPDATE tracks SET lyrics = :lyrics WHERE track_id=:id")
    fun updateTrackLyrics(id: String, lyrics: String)

    @Query("SELECT * FROM tracks WHERE is_favorite = 1 ORDER BY name ASC")
    fun loadFavoriteTracks(): LiveData<List<TrackEntity>>

    @Query("UPDATE tracks SET is_favorite = :isFavorite WHERE track_id = :id")
    suspend fun setTrackIsFavorite(id: String, isFavorite: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrack(trackEntity: TrackEntity)

    @Transaction
    @Query("SELECT * FROM tracks WHERE track_id = :id")
    fun getTrackWithArtists(id: String): TrackWithArtists
}