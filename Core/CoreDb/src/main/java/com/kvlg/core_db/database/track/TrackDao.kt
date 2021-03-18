package com.kvlg.core_db.database.track

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kvlg.spotify_common.entity.TrackEntity

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks WHERE track_id = :id")
    fun getTrackById(id: String): LiveData<TrackEntity?>

    @Query("SELECT * FROM tracks WHERE name LIKE '%' || :query || '%'")
    fun getTracksByQuery(query: String): LiveData<List<TrackEntity>>

    @Query("UPDATE tracks SET lyrics = :lyrics WHERE track_id=:id")
    fun updateTrackLyrics(id: String, lyrics: String?)

    @Query("SELECT * FROM tracks WHERE is_favorite = 1 ORDER BY name ASC")
    fun loadFavoriteTracks(): LiveData<List<TrackEntity>>

    @Query("UPDATE tracks SET is_favorite = :isFavorite WHERE track_id = :id")
    suspend fun setTrackIsFavorite(id: String, isFavorite: Boolean)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTrack(trackEntity: TrackEntity)

    @Query("SELECT * FROM tracks WHERE name LIKE '%' || :name || '%' AND is_favorite = 1 ORDER BY name ASC")
    fun getFavoriteTracksByName(name: String): LiveData<List<TrackEntity>>
}