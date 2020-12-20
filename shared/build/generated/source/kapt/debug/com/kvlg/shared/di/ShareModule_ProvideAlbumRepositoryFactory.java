package com.kvlg.shared.di;

import com.kvlg.network.spotify.DataConverter;
import com.kvlg.network.spotify.SpotifyApi;
import com.kvlg.shared.data.AlbumRepository;
import com.kvlg.shared.data.db.AppDatabase;
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
public final class ShareModule_ProvideAlbumRepositoryFactory implements Factory<AlbumRepository> {
  private final Provider<AppDatabase> databaseProvider;

  private final Provider<SpotifyApi> spotifyApiProvider;

  private final Provider<DataConverter> converterProvider;

  public ShareModule_ProvideAlbumRepositoryFactory(Provider<AppDatabase> databaseProvider,
      Provider<SpotifyApi> spotifyApiProvider, Provider<DataConverter> converterProvider) {
    this.databaseProvider = databaseProvider;
    this.spotifyApiProvider = spotifyApiProvider;
    this.converterProvider = converterProvider;
  }

  @Override
  public AlbumRepository get() {
    return provideAlbumRepository(databaseProvider.get(), spotifyApiProvider.get(), converterProvider.get());
  }

  public static ShareModule_ProvideAlbumRepositoryFactory create(
      Provider<AppDatabase> databaseProvider, Provider<SpotifyApi> spotifyApiProvider,
      Provider<DataConverter> converterProvider) {
    return new ShareModule_ProvideAlbumRepositoryFactory(databaseProvider, spotifyApiProvider, converterProvider);
  }

  public static AlbumRepository provideAlbumRepository(AppDatabase database, SpotifyApi spotifyApi,
      DataConverter converter) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideAlbumRepository(database, spotifyApi, converter), "Cannot return null from a non-@Nullable @Provides method");
  }
}
