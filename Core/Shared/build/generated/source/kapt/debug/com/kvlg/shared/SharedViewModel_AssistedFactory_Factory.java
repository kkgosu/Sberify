// Generated by Dagger (https://dagger.dev).
package com.kvlg.shared;

import com.kvlg.core_db.DatabaseRepository;
import com.kvlg.spotify_api.api.SpotifyApi;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SharedViewModel_AssistedFactory_Factory implements Factory<SharedViewModel_AssistedFactory> {
  private final Provider<SpotifyApi> spofityApiProvider;

  private final Provider<DatabaseRepository> databaseRepositoryProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public SharedViewModel_AssistedFactory_Factory(Provider<SpotifyApi> spofityApiProvider,
      Provider<DatabaseRepository> databaseRepositoryProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.spofityApiProvider = spofityApiProvider;
    this.databaseRepositoryProvider = databaseRepositoryProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public SharedViewModel_AssistedFactory get() {
    return newInstance(spofityApiProvider, databaseRepositoryProvider, ioDispatcherProvider);
  }

  public static SharedViewModel_AssistedFactory_Factory create(
      Provider<SpotifyApi> spofityApiProvider,
      Provider<DatabaseRepository> databaseRepositoryProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new SharedViewModel_AssistedFactory_Factory(spofityApiProvider, databaseRepositoryProvider, ioDispatcherProvider);
  }

  public static SharedViewModel_AssistedFactory newInstance(Provider<SpotifyApi> spofityApi,
      Provider<DatabaseRepository> databaseRepository, Provider<CoroutineDispatcher> ioDispatcher) {
    return new SharedViewModel_AssistedFactory(spofityApi, databaseRepository, ioDispatcher);
  }
}
