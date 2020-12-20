package com.kvlg.shared.di;

import com.kvlg.shared.data.AlbumRepository;
import com.kvlg.shared.domain.album.AlbumUseCasesProvider;
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
public final class ShareModule_ProvideAlbumUseCasesProviderFactory implements Factory<AlbumUseCasesProvider> {
  private final Provider<AlbumRepository> repositoryProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public ShareModule_ProvideAlbumUseCasesProviderFactory(
      Provider<AlbumRepository> repositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.repositoryProvider = repositoryProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public AlbumUseCasesProvider get() {
    return provideAlbumUseCasesProvider(repositoryProvider.get(), dispatcherProvider.get());
  }

  public static ShareModule_ProvideAlbumUseCasesProviderFactory create(
      Provider<AlbumRepository> repositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new ShareModule_ProvideAlbumUseCasesProviderFactory(repositoryProvider, dispatcherProvider);
  }

  public static AlbumUseCasesProvider provideAlbumUseCasesProvider(AlbumRepository repository,
      CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideAlbumUseCasesProvider(repository, dispatcher), "Cannot return null from a non-@Nullable @Provides method");
  }
}
