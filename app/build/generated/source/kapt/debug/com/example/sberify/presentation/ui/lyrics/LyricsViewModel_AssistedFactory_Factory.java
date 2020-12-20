package com.example.sberify.presentation.ui.lyrics;

import com.example.sberify.domain.DatabaseRepository;
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
public final class LyricsViewModel_AssistedFactory_Factory implements Factory<LyricsViewModel_AssistedFactory> {
  private final Provider<DatabaseRepository> databaseRepositoryProvider;

  public LyricsViewModel_AssistedFactory_Factory(
      Provider<DatabaseRepository> databaseRepositoryProvider) {
    this.databaseRepositoryProvider = databaseRepositoryProvider;
  }

  @Override
  public LyricsViewModel_AssistedFactory get() {
    return newInstance(databaseRepositoryProvider);
  }

  public static LyricsViewModel_AssistedFactory_Factory create(
      Provider<DatabaseRepository> databaseRepositoryProvider) {
    return new LyricsViewModel_AssistedFactory_Factory(databaseRepositoryProvider);
  }

  public static LyricsViewModel_AssistedFactory newInstance(
      Provider<DatabaseRepository> databaseRepository) {
    return new LyricsViewModel_AssistedFactory(databaseRepository);
  }
}
