package com.example.sberify.data.db.track

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sberify.domain.model.Track

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks")
    fun getAllTracks(): LiveData<List<Track>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrack(trackEntity: TrackEntity)
}