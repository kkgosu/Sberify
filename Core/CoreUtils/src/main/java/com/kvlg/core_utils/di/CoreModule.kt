package com.kvlg.core.di

import android.content.Context
import androidx.preference.PreferenceManager
import com.kvlg.core.models.TokenData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object CoreModule {

    @Provides
    fun provideTokenData(@ApplicationContext context: Context) = TokenData(PreferenceManager.getDefaultSharedPreferences(context))

}