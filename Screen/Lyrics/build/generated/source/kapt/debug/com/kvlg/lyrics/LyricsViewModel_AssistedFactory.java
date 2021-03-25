package com.kvlg.lyrics;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kvlg.core_db.DatabaseRepository;
import com.kvlg.genius_api.GeniusApi;
import com.kvlg.shared.di.IoDispatcher;
import java.lang.Override;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class LyricsViewModel_AssistedFactory implements ViewModelAssistedFactory<LyricsViewModel> {
  private final Provider<GeniusApi> geniusApi;

  private final Provider<DatabaseRepository> databaseRepository;

  private final Provider<CoroutineDispatcher> dispatcher;

  @Inject
  LyricsViewModel_AssistedFactory(Provider<GeniusApi> geniusApi,
      Provider<DatabaseRepository> databaseRepository,
      @IoDispatcher Provider<CoroutineDispatcher> dispatcher) {
    this.geniusApi = geniusApi;
    this.databaseRepository = databaseRepository;
    this.dispatcher = dispatcher;
  }

  @Override
  @NonNull
  public LyricsViewModel create(SavedStateHandle arg0) {
    return new LyricsViewModel(geniusApi.get(), databaseRepository.get(), dispatcher.get());
  }
}
