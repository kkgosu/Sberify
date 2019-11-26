package com.example.sberify.data.db.album

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlbumEntity::class], version = 1)
abstract class AlbumDatabase : RoomDatabase(){
    abstract fun getAlbumDao(): AlbumDao
}