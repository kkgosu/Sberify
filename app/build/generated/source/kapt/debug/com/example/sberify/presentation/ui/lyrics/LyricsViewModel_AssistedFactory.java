package com.example.sberify.presentation.ui.lyrics;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.example.sberify.domain.DatabaseRepository;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class LyricsViewModel_AssistedFactory implements ViewModelAssistedFactory<LyricsViewModel> {
  private final Provider<DatabaseRepository> databaseRepository;

  @Inject
  LyricsViewModel_AssistedFactory(Provider<DatabaseRepository> databaseRepository) {
    this.databaseRepository = databaseRepository;
  }

  @Override
  @NonNull
  public LyricsViewModel create(SavedStateHandle arg0) {
    return new LyricsViewModel(databaseRepository.get());
  }
}
