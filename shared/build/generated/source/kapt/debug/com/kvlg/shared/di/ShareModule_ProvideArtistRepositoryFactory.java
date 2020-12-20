package com.kvlg.shared.di;

import com.kvlg.network.spotify.DataConverter;
import com.kvlg.network.spotify.SpotifyApi;
import com.kvlg.shared.data.ArtistRepository;
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
public final class ShareModule_ProvideArtistRepositoryFactory implements Factory<ArtistRepository> {
  private final Provider<AppDatabase> databaseProvider;

  private final Provider<SpotifyApi> spotifyApiProvider;

  private final Provider<DataConverter> dataConverterProvider;

  public ShareModule_ProvideArtistRepositoryFactory(Provider<AppDatabase> databaseProvider,
      Provider<SpotifyApi> spotifyApiProvider, Provider<DataConverter> dataConverterProvider) {
    this.databaseProvider = databaseProvider;
    this.spotifyApiProvider = spotifyApiProvider;
    this.dataConverterProvider = dataConverterProvider;
  }

  @Override
  public ArtistRepository get() {
    return provideArtistRepository(databaseProvider.get(), spotifyApiProvider.get(), dataConverterProvider.get());
  }

  public static ShareModule_ProvideArtistRepositoryFactory create(
      Provider<AppDatabase> databaseProvider, Provider<SpotifyApi> spotifyApiProvider,
      Provider<DataConverter> dataConverterProvider) {
    return new ShareModule_ProvideArtistRepositoryFactory(databaseProvider, spotifyApiProvider, dataConverterProvider);
  }

  public static ArtistRepository provideArtistRepository(AppDatabase database,
      SpotifyApi spotifyApi, DataConverter dataConverter) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideArtistRepository(database, spotifyApi, dataConverter), "Cannot return null from a non-@Nullable @Provides method");
  }
}
