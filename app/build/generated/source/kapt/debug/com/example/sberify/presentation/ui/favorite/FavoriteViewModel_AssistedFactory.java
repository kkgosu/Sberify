package com.example.sberify.presentation.ui.favorite;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kvlg.core_db.DatabaseRepository;
import com.kvlg.spotify_api.converter.ViewModelConverter;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class FavoriteViewModel_AssistedFactory implements ViewModelAssistedFactory<FavoriteViewModel> {
  private final Provider<DatabaseRepository> databaseRepo;

  private final Provider<ViewModelConverter> modelConverter;

  @Inject
  FavoriteViewModel_AssistedFactory(Provider<DatabaseRepository> databaseRepo,
      Provider<ViewModelConverter> modelConverter) {
    this.databaseRepo = databaseRepo;
    this.modelConverter = modelConverter;
  }

  @Override
  @NonNull
  public FavoriteViewModel create(SavedStateHandle arg0) {
    return new FavoriteViewModel(databaseRepo.get(), modelConverter.get());
  }
}
