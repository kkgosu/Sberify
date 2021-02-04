package com.example.sberify.presentation.ui;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kvlg.core.DatabaseRepository;
import com.kvlg.genius_api.GeniusApi;
import com.kvlg.spotify_api.api.SpotifyApi;
import java.lang.Override;
import javax.inject.Inject;
import javax.inject.Provider;

public final class SharedViewModel_AssistedFactory implements ViewModelAssistedFactory<SharedViewModel> {
  private final Provider<SpotifyApi> spofityApi;

  private final Provider<GeniusApi> geniusApi;

  private final Provider<DatabaseRepository> databaseRepository;

  @Inject
  SharedViewModel_AssistedFactory(Provider<SpotifyApi> spofityApi, Provider<GeniusApi> geniusApi,
      Provider<DatabaseRepository> databaseRepository) {
    this.spofityApi = spofityApi;
    this.geniusApi = geniusApi;
    this.databaseRepository = databaseRepository;
  }

  @Override
  @NonNull
  public SharedViewModel create(SavedStateHandle arg0) {
    return new SharedViewModel(spofityApi.get(), geniusApi.get(), databaseRepository.get());
  }
}
