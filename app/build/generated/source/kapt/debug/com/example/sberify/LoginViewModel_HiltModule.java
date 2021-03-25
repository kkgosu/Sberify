package com.example.sberify;

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
    topLevelClass = LoginViewModel.class
)
public interface LoginViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.example.sberify.LoginViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(LoginViewModel_AssistedFactory factory);
}
