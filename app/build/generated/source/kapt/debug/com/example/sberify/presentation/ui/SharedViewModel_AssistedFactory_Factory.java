package com.example.sberify.presentation.ui;

import com.example.sberify.domain.DatabaseRepository;
import com.example.sberify.domain.IGeniusRepository;
import com.example.sberify.domain.ISpotifyRepository;
import com.example.sberify.domain.TokenData;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SharedViewModel_AssistedFactory_Factory implements Factory<SharedViewModel_AssistedFactory> {
  private final Provider<ISpotifyRepository> spotifyRepositoryProvider;

  private final Provider<IGeniusRepository> geniusRepositoryProvider;

  private final Provider<DatabaseRepository> databaseRepositoryProvider;

  private final Provider<TokenData> tokenDataProvider;

  public SharedViewModel_AssistedFactory_Factory(
      Provider<ISpotifyRepository> spotifyRepositoryProvider,
      Provider<IGeniusRepository> geniusRepositoryProvider,
      Provider<DatabaseRepository> databaseRepositoryProvider,
      Provider<TokenData> tokenDataProvider) {
    this.spotifyRepositoryProvider = spotifyRepositoryProvider;
    this.geniusRepositoryProvider = geniusRepositoryProvider;
    this.databaseRepositoryProvider = databaseRepositoryProvider;
    this.tokenDataProvider = tokenDataProvider;
  }

  @Override
  public SharedViewModel_AssistedFactory get() {
    return newInstance(spotifyRepositoryProvider, geniusRepositoryProvider, databaseRepositoryProvider, tokenDataProvider);
  }

  public static SharedViewModel_AssistedFactory_Factory create(
      Provider<ISpotifyRepository> spotifyRepositoryProvider,
      Provider<IGeniusRepository> geniusRepositoryProvider,
      Provider<DatabaseRepository> databaseRepositoryProvider,
      Provider<TokenData> tokenDataProvider) {
    return new SharedViewModel_AssistedFactory_Factory(spotifyRepositoryProvider, geniusRepositoryProvider, databaseRepositoryProvider, tokenDataProvider);
  }

  public static SharedViewModel_AssistedFactory newInstance(
      Provider<ISpotifyRepository> spotifyRepository, Provider<IGeniusRepository> geniusRepository,
      Provider<DatabaseRepository> databaseRepository, Provider<TokenData> tokenData) {
    return new SharedViewModel_AssistedFactory(spotifyRepository, geniusRepository, databaseRepository, tokenData);
  }
}
