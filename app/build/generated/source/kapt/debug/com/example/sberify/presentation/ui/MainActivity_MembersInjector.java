package com.example.sberify.presentation.ui;

import com.example.sberify.domain.TokenData;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<TokenData> tokenDataProvider;

  public MainActivity_MembersInjector(Provider<TokenData> tokenDataProvider) {
    this.tokenDataProvider = tokenDataProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<TokenData> tokenDataProvider) {
    return new MainActivity_MembersInjector(tokenDataProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectTokenData(instance, tokenDataProvider.get());
  }

  @InjectedFieldSignature("com.example.sberify.presentation.ui.MainActivity.tokenData")
  public static void injectTokenData(MainActivity instance, TokenData tokenData) {
    instance.tokenData = tokenData;
  }
}
