package com.example.sberify.data.db.suggestions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.sberify.models.domain.Suggestion


@Entity(tableName = "suggestions", indices = [Index(value = ["text"], unique = true)])
data class SuggestionsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long?,

    @ColumnInfo(name = "text")
    val text: String
) {

    fun toSuggestion(): Suggestion =
        Suggestion(text)

    companion object {
        fun from(suggestion: Suggestion): SuggestionsEntity =
            SuggestionsEntity(id = null, text = suggestion.text)
    }
}