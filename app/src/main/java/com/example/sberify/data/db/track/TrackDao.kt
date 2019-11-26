package com.example.sberify.data.db.track

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks WHERE spotify_id = :id")
    fun getTracksById(id: String): LiveData<TrackEntity>

    @Query("SELECT * FROM tracks WHERE album_id = :id")
    fun getTracksByAlbumId(id: String): LiveData<List<TrackEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrack(trackEntity: TrackEntity)
}