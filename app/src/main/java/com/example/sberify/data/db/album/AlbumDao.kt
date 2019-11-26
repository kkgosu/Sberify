package com.example.sberify.data.db.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbum(albumEntity: AlbumEntity)

    @Query("SELECT * FROM albums WHERE spotify_id = :id")
    fun getAlbumById(id: String): LiveData<AlbumEntity>

    @Query("SELECT * FROM albums WHERE artist_id = :id")
    fun getAlbumsByArtistId(id: String): LiveData<List<AlbumEntity>>
}