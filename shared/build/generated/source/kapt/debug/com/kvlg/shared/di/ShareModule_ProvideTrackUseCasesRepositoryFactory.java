package com.kvlg.shared.di;

import com.kvlg.shared.data.TrackRepository;
import com.kvlg.shared.domain.track.TrackUseCasesProvider;
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
public final class ShareModule_ProvideTrackUseCasesRepositoryFactory implements Factory<TrackUseCasesProvider> {
  private final Provider<TrackRepository> trackRepoProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public ShareModule_ProvideTrackUseCasesRepositoryFactory(
      Provider<TrackRepository> trackRepoProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.trackRepoProvider = trackRepoProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public TrackUseCasesProvider get() {
    return provideTrackUseCasesRepository(trackRepoProvider.get(), dispatcherProvider.get());
  }

  public static ShareModule_ProvideTrackUseCasesRepositoryFactory create(
      Provider<TrackRepository> trackRepoProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new ShareModule_ProvideTrackUseCasesRepositoryFactory(trackRepoProvider, dispatcherProvider);
  }

  public static TrackUseCasesProvider provideTrackUseCasesRepository(TrackRepository trackRepo,
      CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideTrackUseCasesRepository(trackRepo, dispatcher), "Cannot return null from a non-@Nullable @Provides method");
  }
}
