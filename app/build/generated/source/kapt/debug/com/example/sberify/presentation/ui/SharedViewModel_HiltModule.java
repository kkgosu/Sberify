package com.example.sberify.presentation.ui;

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
    topLevelClass = SharedViewModel.class
)
public interface SharedViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.example.sberify.presentation.ui.SharedViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(SharedViewModel_AssistedFactory factory);
}
