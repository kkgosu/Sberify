package com.kvlg.core_db.database.suggestions

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuggestionsDao {
    @Query("DELETE FROM suggestions WHERE id NOT IN (SELECT id FROM suggestions ORDER BY id DESC LIMIT 5)")
    fun checkLimitAndDelete()

    @Query("SELECT * FROM suggestions ORDER BY id DESC")
    fun getAllSuggestions(): LiveData<List<SuggestionsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSuggestion(suggestionsEntity: SuggestionsEntity)
}