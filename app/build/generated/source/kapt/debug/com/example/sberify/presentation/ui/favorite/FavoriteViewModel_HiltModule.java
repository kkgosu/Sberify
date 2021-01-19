package com.example.sberify.presentation.ui.favorite;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = FavoriteViewModel.class
)
public interface FavoriteViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.example.sberify.presentation.ui.favorite.FavoriteViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(FavoriteViewModel_AssistedFactory factory);
}