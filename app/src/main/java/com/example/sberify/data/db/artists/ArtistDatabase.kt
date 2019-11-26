package com.example.sberify.data.db.artists

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArtistEntity::class], version = 1)
abstract class ArtistDatabase: RoomDatabase() {
    abstract fun getArtistDao(): ArtistDao
}