package com.example.sberify.presentation.ui;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kvlg.core_db.DatabaseRepository;
import com.kvlg.core_utils.models.TokenData;
import com.kvlg.genius_api.GeniusApi;
import com.kvlg.spotify_api.api.SpotifyApi;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class SharedViewModel_AssistedFactory implements ViewModelAssistedFactory<SharedViewModel> {
  private final Provider<SpotifyApi> spofityApi;

  private final Provider<GeniusApi> geniusApi;

  private final Provider<DatabaseRepository> databaseRepository;

  private final Provider<TokenData> tokenData;

  @Inject
  SharedViewModel_AssistedFactory(Provider<SpotifyApi> spofityApi, Provider<GeniusApi> geniusApi,
      Provider<DatabaseRepository> databaseRepository, Provider<TokenData> tokenData) {
    this.spofityApi = spofityApi;
    this.geniusApi = geniusApi;
    this.databaseRepository = databaseRepository;
    this.tokenData = tokenData;
  }

  @Override
  @NonNull
  public SharedViewModel create(SavedStateHandle arg0) {
    return new SharedViewModel(spofityApi.get(), geniusApi.get(), databaseRepository.get(),
        tokenData.get());
  }
}
