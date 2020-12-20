package com.kvlg.network.di;

import com.kvlg.network.TokenData;
import com.kvlg.network.genius.GeniusAuthInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class NetworkModule_ProvideGeniusInterceptorFactory implements Factory<GeniusAuthInterceptor> {
  private final NetworkModule module;

  private final Provider<TokenData> tokenDataProvider;

  public NetworkModule_ProvideGeniusInterceptorFactory(NetworkModule module,
      Provider<TokenData> tokenDataProvider) {
    this.module = module;
    this.tokenDataProvider = tokenDataProvider;
  }

  @Override
  public GeniusAuthInterceptor get() {
    return provideGeniusInterceptor(module, tokenDataProvider.get());
  }

  public static NetworkModule_ProvideGeniusInterceptorFactory create(NetworkModule module,
      Provider<TokenData> tokenDataProvider) {
    return new NetworkModule_ProvideGeniusInterceptorFactory(module, tokenDataProvider);
  }

  public static GeniusAuthInterceptor provideGeniusInterceptor(NetworkModule instance,
      TokenData tokenData) {
    return Preconditions.checkNotNull(instance.provideGeniusInterceptor(tokenData), "Cannot return null from a non-@Nullable @Provides method");
  }
}
