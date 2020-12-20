package com.example.sberify.data.repository;

import com.example.sberify.data.DbConverter;
import com.example.sberify.data.ResponseConverter;
import com.example.sberify.data.api.ISpotifyApi;
import com.example.sberify.data.db.AppDatabase;
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
public final class SpotifyRepository_Factory implements Factory<SpotifyRepository> {
  private final Provider<AppDatabase> databaseProvider;

  private final Provider<ISpotifyApi> spotifyApiProvider;

  private final Provider<DbConverter> dbConverterProvider;

  private final Provider<ResponseConverter> responseConverterProvider;

  public SpotifyRepository_Factory(Provider<AppDatabase> databaseProvider,
      Provider<ISpotifyApi> spotifyApiProvider, Provider<DbConverter> dbConverterProvider,
      Provider<ResponseConverter> responseConverterProvider) {
    this.databaseProvider = databaseProvider;
    this.spotifyApiProvider = spotifyApiProvider;
    this.dbConverterProvider = dbConverterProvider;
    this.responseConverterProvider = responseConverterProvider;
  }

  @Override
  public SpotifyRepository get() {
    return newInstance(databaseProvider.get(), spotifyApiProvider.get(), dbConverterProvider.get(), responseConverterProvider.get());
  }

  public static SpotifyRepository_Factory create(Provider<AppDatabase> databaseProvider,
      Provider<ISpotifyApi> spotifyApiProvider, Provider<DbConverter> dbConverterProvider,
      Provider<ResponseConverter> responseConverterProvider) {
    return new SpotifyRepository_Factory(databaseProvider, spotifyApiProvider, dbConverterProvider, responseConverterProvider);
  }

  public static SpotifyRepository newInstance(AppDatabase database, ISpotifyApi spotifyApi,
      DbConverter dbConverter, ResponseConverter responseConverter) {
    return new SpotifyRepository(database, spotifyApi, dbConverter, responseConverter);
  }
}
