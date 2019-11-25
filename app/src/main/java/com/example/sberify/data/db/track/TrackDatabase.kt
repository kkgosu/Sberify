package com.example.sberify.data.db.track

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =[TrackEntity::class], version = 1)
abstract class TrackDatabase: RoomDatabase() {
    abstract fun getTrackDao() : TrackDao
}