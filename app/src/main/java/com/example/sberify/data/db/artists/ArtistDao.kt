package com.example.sberify.data.db.artists

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtist(artistEntity: ArtistEntity)

    @Query("SELECT * FROM artists WHERE artist_id = :id")
    fun getArtistById(id: String): LiveData<ArtistEntity>

    @Query("SELECT * FROM artists WHERE name LIKE '%' || :key || '%'")
    fun getArtistByKeyword(key: String): LiveData<List<ArtistEntity>>

    @Transaction
    @Query("SELECT * FROM artists WHERE artist_id = :artistId")
    fun getAlbums(artistId: String): LiveData<ArtistWithAlbums>

    @Query("SELECT * FROM artists WHERE name LIKE '%' || :query || '%'")
    fun getArtistByQuery(query: String): LiveData<List<ArtistEntity>>

    @Transaction
    @Query("SELECT * FROM artists WHERE artist_id = :artistId")
    fun getArtistWithSongs(artistId: String): ArtistWithTracks
}