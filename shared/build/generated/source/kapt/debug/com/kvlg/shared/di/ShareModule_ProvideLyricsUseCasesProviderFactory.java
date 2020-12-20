package com.kvlg.shared.di;

import com.kvlg.shared.data.LyricsRepository;
import com.kvlg.shared.domain.lyrics.LyricsUseCasesProvider;
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
public final class ShareModule_ProvideLyricsUseCasesProviderFactory implements Factory<LyricsUseCasesProvider> {
  private final Provider<LyricsRepository> lyricsRepositoryProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public ShareModule_ProvideLyricsUseCasesProviderFactory(
      Provider<LyricsRepository> lyricsRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.lyricsRepositoryProvider = lyricsRepositoryProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public LyricsUseCasesProvider get() {
    return provideLyricsUseCasesProvider(lyricsRepositoryProvider.get(), dispatcherProvider.get());
  }

  public static ShareModule_ProvideLyricsUseCasesProviderFactory create(
      Provider<LyricsRepository> lyricsRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new ShareModule_ProvideLyricsUseCasesProviderFactory(lyricsRepositoryProvider, dispatcherProvider);
  }

  public static LyricsUseCasesProvider provideLyricsUseCasesProvider(
      LyricsRepository lyricsRepository, CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideLyricsUseCasesProvider(lyricsRepository, dispatcher), "Cannot return null from a non-@Nullable @Provides method");
  }
}
