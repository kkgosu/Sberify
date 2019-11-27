package com.example.sberify.data.db.album

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sberify.data.db.TrackIdConverter

@Database(entities = [AlbumEntity::class], version = 2)
@TypeConverters(TrackIdConverter::class)
abstract class AlbumDatabase : RoomDatabase() {
    abstract fun getAlbumDao(): AlbumDao
}