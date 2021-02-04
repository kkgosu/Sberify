package com.example.sberify.presentation.ui.lyrics;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = LyricsViewModel.class
)
public interface LyricsViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.example.sberify.presentation.ui.lyrics.LyricsViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(LyricsViewModel_AssistedFactory factory);
}
