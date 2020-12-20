package com.kvlg.shared.di;

import com.kvlg.shared.data.SuggestionsRepository;
import com.kvlg.shared.domain.suggestions.SuggestionUseCasesProvider;
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
public final class ShareModule_ProvideSuggestionUseCasesProviderFactory implements Factory<SuggestionUseCasesProvider> {
  private final Provider<SuggestionsRepository> repositoryProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public ShareModule_ProvideSuggestionUseCasesProviderFactory(
      Provider<SuggestionsRepository> repositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.repositoryProvider = repositoryProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public SuggestionUseCasesProvider get() {
    return provideSuggestionUseCasesProvider(repositoryProvider.get(), dispatcherProvider.get());
  }

  public static ShareModule_ProvideSuggestionUseCasesProviderFactory create(
      Provider<SuggestionsRepository> repositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new ShareModule_ProvideSuggestionUseCasesProviderFactory(repositoryProvider, dispatcherProvider);
  }

  public static SuggestionUseCasesProvider provideSuggestionUseCasesProvider(
      SuggestionsRepository repository, CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideSuggestionUseCasesProvider(repository, dispatcher), "Cannot return null from a non-@Nullable @Provides method");
  }
}
