package com.kvlg.shared.di

import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.suggestions.SuggestionRepositoryImpl
import com.kvlg.shared.data.suggestions.SuggestionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author Konstantin Koval
 * @since 24.10.2020
 */
@Module
@InstallIn(ApplicationComponent::class)
object ShareModule {

    @Singleton
    @Provides
    fun provideSuggestionsRepository(
        database: AppDatabase
    ): SuggestionsRepository {
        return SuggestionRepositoryImpl(database)
    }
}