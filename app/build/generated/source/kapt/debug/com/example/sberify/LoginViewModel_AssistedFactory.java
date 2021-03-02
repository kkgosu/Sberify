package com.example.sberify;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kvlg.core_utils.models.TokenData;
import java.lang.Override;
import javax.inject.Inject;
import javax.inject.Provider;

public final class LoginViewModel_AssistedFactory implements ViewModelAssistedFactory<LoginViewModel> {
  private final Provider<TokenData> tokenData;

  @Inject
  LoginViewModel_AssistedFactory(Provider<TokenData> tokenData) {
    this.tokenData = tokenData;
  }

  @Override
  @NonNull
  public LoginViewModel create(SavedStateHandle arg0) {
    return new LoginViewModel(tokenData.get());
  }
}
