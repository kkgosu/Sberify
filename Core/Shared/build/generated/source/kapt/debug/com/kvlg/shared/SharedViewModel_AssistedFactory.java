package com.kvlg.shared;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kvlg.core_db.DatabaseRepository;
import com.kvlg.shared.di.IoDispatcher;
import com.kvlg.spotify_api.api.SpotifyApi;
import java.lang.Override;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class SharedViewModel_AssistedFactory implements ViewModelAssistedFactory<SharedViewModel> {
  private final Provider<SpotifyApi> spofityApi;

  private final Provider<DatabaseRepository> databaseRepository;

  private final Provider<CoroutineDispatcher> ioDispatcher;

  @Inject
  SharedViewModel_AssistedFactory(Provider<SpotifyApi> spofityApi,
      Provider<DatabaseRepository> databaseRepository,
      @IoDispatcher Provider<CoroutineDispatcher> ioDispatcher) {
    this.spofityApi = spofityApi;
    this.databaseRepository = databaseRepository;
    this.ioDispatcher = ioDispatcher;
  }

  @Override
  @NonNull
  public SharedViewModel create(SavedStateHandle arg0) {
    return new SharedViewModel(spofityApi.get(), databaseRepository.get(), ioDispatcher.get());
  }
}
