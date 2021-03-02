package com.kvlg.lyrics;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kvlg.core_db.DatabaseRepository;
import com.kvlg.genius_api.GeniusApi;
import java.lang.Override;
import javax.inject.Inject;
import javax.inject.Provider;

public final class LyricsViewModel_AssistedFactory implements ViewModelAssistedFactory<LyricsViewModel> {
  private final Provider<GeniusApi> geniusApi;

  private final Provider<DatabaseRepository> databaseRepository;

  @Inject
  LyricsViewModel_AssistedFactory(Provider<GeniusApi> geniusApi,
      Provider<DatabaseRepository> databaseRepository) {
    this.geniusApi = geniusApi;
    this.databaseRepository = databaseRepository;
  }

  @Override
  @NonNull
  public LyricsViewModel create(SavedStateHandle arg0) {
    return new LyricsViewModel(geniusApi.get(), databaseRepository.get());
  }
}
