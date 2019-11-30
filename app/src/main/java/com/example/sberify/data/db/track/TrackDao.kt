package com.example.sberify.data.db.track

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks WHERE spotify_id = :id")
    fun getTracksById(id: String): LiveData<TrackEntity>

    @Query("SELECT * FROM tracks WHERE album_id = :id")
    fun getTracksByAlbumId(id: String): LiveData<List<TrackEntity>>

    @Query("UPDATE tracks SET lyrics = :lyrics WHERE spotify_id=:id")
    fun updateTrackLyrics(id: String, lyrics: String)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTrack(trackEntity: TrackEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrack(trackEntity: TrackEntity)
}