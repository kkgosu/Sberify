package com.example.sberify.presentation.ui;

import com.kvlg.core_db.DatabaseRepository;
import com.kvlg.core_utils.models.TokenData;
import com.kvlg.genius_api.GeniusApi;
import com.kvlg.spotify_api.api.SpotifyApi;
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
  private final Provider<SpotifyApi> spofityApiProvider;

  private final Provider<GeniusApi> geniusApiProvider;

  private final Provider<DatabaseRepository> databaseRepositoryProvider;

  private final Provider<TokenData> tokenDataProvider;

  public SharedViewModel_AssistedFactory_Factory(Provider<SpotifyApi> spofityApiProvider,
      Provider<GeniusApi> geniusApiProvider,
      Provider<DatabaseRepository> databaseRepositoryProvider,
      Provider<TokenData> tokenDataProvider) {
    this.spofityApiProvider = spofityApiProvider;
    this.geniusApiProvider = geniusApiProvider;
    this.databaseRepositoryProvider = databaseRepositoryProvider;
    this.tokenDataProvider = tokenDataProvider;
  }

  @Override
  public SharedViewModel_AssistedFactory get() {
    return newInstance(spofityApiProvider, geniusApiProvider, databaseRepositoryProvider, tokenDataProvider);
  }

  public static SharedViewModel_AssistedFactory_Factory create(
      Provider<SpotifyApi> spofityApiProvider, Provider<GeniusApi> geniusApiProvider,
      Provider<DatabaseRepository> databaseRepositoryProvider,
      Provider<TokenData> tokenDataProvider) {
    return new SharedViewModel_AssistedFactory_Factory(spofityApiProvider, geniusApiProvider, databaseRepositoryProvider, tokenDataProvider);
  }

  public static SharedViewModel_AssistedFactory newInstance(Provider<SpotifyApi> spofityApi,
      Provider<GeniusApi> geniusApi, Provider<DatabaseRepository> databaseRepository,
      Provider<TokenData> tokenData) {
    return new SharedViewModel_AssistedFactory(spofityApi, geniusApi, databaseRepository, tokenData);
  }
}
