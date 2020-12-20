package com.example.sberify.presentation.ui;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.example.sberify.domain.DatabaseRepository;
import com.example.sberify.domain.IGeniusRepository;
import com.example.sberify.domain.ISpotifyRepository;
import com.example.sberify.domain.TokenData;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class SharedViewModel_AssistedFactory implements ViewModelAssistedFactory<SharedViewModel> {
  private final Provider<ISpotifyRepository> spotifyRepository;

  private final Provider<IGeniusRepository> geniusRepository;

  private final Provider<DatabaseRepository> databaseRepository;

  private final Provider<TokenData> tokenData;

  @Inject
  SharedViewModel_AssistedFactory(Provider<ISpotifyRepository> spotifyRepository,
      Provider<IGeniusRepository> geniusRepository, Provider<DatabaseRepository> databaseRepository,
      Provider<TokenData> tokenData) {
    this.spotifyRepository = spotifyRepository;
    this.geniusRepository = geniusRepository;
    this.databaseRepository = databaseRepository;
    this.tokenData = tokenData;
  }

  @Override
  @NonNull
  public SharedViewModel create(SavedStateHandle arg0) {
    return new SharedViewModel(spotifyRepository.get(), geniusRepository.get(),
        databaseRepository.get(), tokenData.get());
  }
}
