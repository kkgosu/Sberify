package com.kvlg.shared.di;

import com.kvlg.shared.data.ArtistRepository;
import com.kvlg.shared.domain.artist.ArtistUseCasesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ShareModule_ProvideArtistUseCasesProviderFactory implements Factory<ArtistUseCasesProvider> {
  private final Provider<ArtistRepository> artistRepositoryProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public ShareModule_ProvideArtistUseCasesProviderFactory(
      Provider<ArtistRepository> artistRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.artistRepositoryProvider = artistRepositoryProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public ArtistUseCasesProvider get() {
    return provideArtistUseCasesProvider(artistRepositoryProvider.get(), dispatcherProvider.get());
  }

  public static ShareModule_ProvideArtistUseCasesProviderFactory create(
      Provider<ArtistRepository> artistRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new ShareModule_ProvideArtistUseCasesProviderFactory(artistRepositoryProvider, dispatcherProvider);
  }

  public static ArtistUseCasesProvider provideArtistUseCasesProvider(
      ArtistRepository artistRepository, CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideArtistUseCasesProvider(artistRepository, dispatcher), "Cannot return null from a non-@Nullable @Provides method");
  }
}
