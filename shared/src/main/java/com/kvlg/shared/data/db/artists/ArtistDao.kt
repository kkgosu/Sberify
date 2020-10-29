package com.kvlg.shared.data.db.artists

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtist(artistEntity: ArtistEntity)

    @Query("SELECT * FROM artists WHERE spotify_id = :id")
    fun getArtistById(id: String): LiveData<ArtistEntity>

    @Query("SELECT * FROM artists WHERE name LIKE '%' || :key || '%'")
    fun getArtistByKeyword(key: String): List<ArtistEntity>
}