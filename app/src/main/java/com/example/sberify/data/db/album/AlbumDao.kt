package com.example.sberify.data.db.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlbum(albumEntity: AlbumEntity)

    @Query("SELECT * FROM albums ORDER BY release_date DESC LIMIT 50")
    fun getAlbums(): LiveData<List<AlbumEntity>>

    @Query("SELECT * FROM albums WHERE name LIKE '%' || :key || '%'")
    fun getAlbumsByKeyword(key: String): LiveData<List<AlbumEntity>>

    @Query("SELECT * FROM albums WHERE album_id = :id")
    fun getAlbumById(id: String): LiveData<AlbumEntity>

    @Update(entity = AlbumEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAlbumTracks(albumEntity: AlbumEntity)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateAlbum(albumEntity: AlbumEntity)

    @Query("SELECT * FROM albums WHERE is_favorite = 1 ORDER BY name ASC")
    fun loadFavoriteAlbums(): LiveData<List<AlbumEntity>>

    @Transaction
    @Query("SELECT * FROM albums WHERE album_id = :id")
    fun getAlbumTracks(id: String): LiveData<AlbumWithTracks>

    @Query("SELECT * FROM albums ORDER BY release_date DESC LIMIT 50")
    fun getAllAlbums(): LiveData<List<AlbumEntity>>

    @Query("SELECT * FROM albums WHERE name LIKE '%' || :query || '%'")
    fun getAlbumsByQuery(query: String): LiveData<List<AlbumEntity>>

}