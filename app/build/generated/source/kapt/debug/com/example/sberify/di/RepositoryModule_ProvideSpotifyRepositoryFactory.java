package com.example.sberify.di;

import com.example.sberify.data.DbConverter;
import com.example.sberify.data.ResponseConverter;
import com.example.sberify.data.api.ISpotifyApi;
import com.example.sberify.data.db.AppDatabase;
import com.example.sberify.domain.ISpotifyRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class RepositoryModule_ProvideSpotifyRepositoryFactory implements Factory<ISpotifyRepository> {
  private final RepositoryModule module;

  private final Provider<AppDatabase> databaseProvider;

  private final Provider<ISpotifyApi> spotifyApiProvider;

  private final Provider<DbConverter> dbConverterProvider;

  private final Provider<ResponseConverter> responseConverterProvider;

  public RepositoryModule_ProvideSpotifyRepositoryFactory(RepositoryModule module,
      Provider<AppDatabase> databaseProvider, Provider<ISpotifyApi> spotifyApiProvider,
      Provider<DbConverter> dbConverterProvider,
      Provider<ResponseConverter> responseConverterProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
    this.spotifyApiProvider = spotifyApiProvider;
    this.dbConverterProvider = dbConverterProvider;
    this.responseConverterProvider = responseConverterProvider;
  }

  @Override
  public ISpotifyRepository get() {
    return provideSpotifyRepository(module, databaseProvider.get(), spotifyApiProvider.get(), dbConverterProvider.get(), responseConverterProvider.get());
  }

  public static RepositoryModule_ProvideSpotifyRepositoryFactory create(RepositoryModule module,
      Provider<AppDatabase> databaseProvider, Provider<ISpotifyApi> spotifyApiProvider,
      Provider<DbConverter> dbConverterProvider,
      Provider<ResponseConverter> responseConverterProvider) {
    return new RepositoryModule_ProvideSpotifyRepositoryFactory(module, databaseProvider, spotifyApiProvider, dbConverterProvider, responseConverterProvider);
  }

  public static ISpotifyRepository provideSpotifyRepository(RepositoryModule instance,
      AppDatabase database, ISpotifyApi spotifyApi, DbConverter dbConverter,
      ResponseConverter responseConverter) {
    return Preconditions.checkNotNull(instance.provideSpotifyRepository(database, spotifyApi, dbConverter, responseConverter), "Cannot return null from a non-@Nullable @Provides method");
  }
}
