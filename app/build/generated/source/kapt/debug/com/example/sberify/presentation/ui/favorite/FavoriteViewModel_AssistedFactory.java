package com.example.sberify.presentation.ui.favorite;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.example.sberify.domain.DatabaseRepository;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class FavoriteViewModel_AssistedFactory implements ViewModelAssistedFactory<FavoriteViewModel> {
  private final Provider<DatabaseRepository> databaseRepo;

  @Inject
  FavoriteViewModel_AssistedFactory(Provider<DatabaseRepository> databaseRepo) {
    this.databaseRepo = databaseRepo;
  }

  @Override
  @NonNull
  public FavoriteViewModel create(SavedStateHandle arg0) {
    return new FavoriteViewModel(databaseRepo.get());
  }
}
