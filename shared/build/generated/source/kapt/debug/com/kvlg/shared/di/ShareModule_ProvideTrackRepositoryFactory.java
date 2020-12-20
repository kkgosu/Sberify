package com.kvlg.shared.di;

import com.kvlg.network.spotify.DataConverter;
import com.kvlg.network.spotify.SpotifyApi;
import com.kvlg.shared.data.TrackRepository;
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
public final class ShareModule_ProvideTrackRepositoryFactory implements Factory<TrackRepository> {
  private final Provider<AppDatabase> appDatabaseProvider;

  private final Provider<SpotifyApi> spotifyApiProvider;

  private final Provider<DataConverter> converterProvider;

  public ShareModule_ProvideTrackRepositoryFactory(Provider<AppDatabase> appDatabaseProvider,
      Provider<SpotifyApi> spotifyApiProvider, Provider<DataConverter> converterProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
    this.spotifyApiProvider = spotifyApiProvider;
    this.converterProvider = converterProvider;
  }

  @Override
  public TrackRepository get() {
    return provideTrackRepository(appDatabaseProvider.get(), spotifyApiProvider.get(), converterProvider.get());
  }

  public static ShareModule_ProvideTrackRepositoryFactory create(
      Provider<AppDatabase> appDatabaseProvider, Provider<SpotifyApi> spotifyApiProvider,
      Provider<DataConverter> converterProvider) {
    return new ShareModule_ProvideTrackRepositoryFactory(appDatabaseProvider, spotifyApiProvider, converterProvider);
  }

  public static TrackRepository provideTrackRepository(AppDatabase appDatabase,
      SpotifyApi spotifyApi, DataConverter converter) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideTrackRepository(appDatabase, spotifyApi, converter), "Cannot return null from a non-@Nullable @Provides method");
  }
}
