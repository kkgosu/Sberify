package com.example.sberify.presentation.ui.favorite;

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
public final class FavoriteViewModel_AssistedFactory_Factory implements Factory<FavoriteViewModel_AssistedFactory> {
  private final Provider<DatabaseRepository> databaseRepoProvider;

  public FavoriteViewModel_AssistedFactory_Factory(
      Provider<DatabaseRepository> databaseRepoProvider) {
    this.databaseRepoProvider = databaseRepoProvider;
  }

  @Override
  public FavoriteViewModel_AssistedFactory get() {
    return newInstance(databaseRepoProvider);
  }

  public static FavoriteViewModel_AssistedFactory_Factory create(
      Provider<DatabaseRepository> databaseRepoProvider) {
    return new FavoriteViewModel_AssistedFactory_Factory(databaseRepoProvider);
  }

  public static FavoriteViewModel_AssistedFactory newInstance(
      Provider<DatabaseRepository> databaseRepo) {
    return new FavoriteViewModel_AssistedFactory(databaseRepo);
  }
}
