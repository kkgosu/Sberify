package com.example.sberify.presentation.ui.favorite;

import com.kvlg.core_db.DatabaseRepository;
import com.kvlg.spotify_api.converter.ViewModelConverter;
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

  private final Provider<ViewModelConverter> modelConverterProvider;

  public FavoriteViewModel_AssistedFactory_Factory(
      Provider<DatabaseRepository> databaseRepoProvider,
      Provider<ViewModelConverter> modelConverterProvider) {
    this.databaseRepoProvider = databaseRepoProvider;
    this.modelConverterProvider = modelConverterProvider;
  }

  @Override
  public FavoriteViewModel_AssistedFactory get() {
    return newInstance(databaseRepoProvider, modelConverterProvider);
  }

  public static FavoriteViewModel_AssistedFactory_Factory create(
      Provider<DatabaseRepository> databaseRepoProvider,
      Provider<ViewModelConverter> modelConverterProvider) {
    return new FavoriteViewModel_AssistedFactory_Factory(databaseRepoProvider, modelConverterProvider);
  }

  public static FavoriteViewModel_AssistedFactory newInstance(
      Provider<DatabaseRepository> databaseRepo, Provider<ViewModelConverter> modelConverter) {
    return new FavoriteViewModel_AssistedFactory(databaseRepo, modelConverter);
  }
}
