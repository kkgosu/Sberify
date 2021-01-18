package com.kvlg.spotify_impl.data.database.suggestions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "suggestions", indices = [Index(value = ["text"], unique = true)])
data class SuggestionsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long?,

    @ColumnInfo(name = "text")
    val text: String
)