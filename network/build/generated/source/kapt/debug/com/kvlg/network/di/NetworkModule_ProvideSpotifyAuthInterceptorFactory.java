package com.kvlg.network.di;

import com.kvlg.network.TokenData;
import com.kvlg.network.spotify.SpotifyAuthInterceptor;
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
public final class NetworkModule_ProvideSpotifyAuthInterceptorFactory implements Factory<SpotifyAuthInterceptor> {
  private final NetworkModule module;

  private final Provider<TokenData> tokenDataProvider;

  public NetworkModule_ProvideSpotifyAuthInterceptorFactory(NetworkModule module,
      Provider<TokenData> tokenDataProvider) {
    this.module = module;
    this.tokenDataProvider = tokenDataProvider;
  }

  @Override
  public SpotifyAuthInterceptor get() {
    return provideSpotifyAuthInterceptor(module, tokenDataProvider.get());
  }

  public static NetworkModule_ProvideSpotifyAuthInterceptorFactory create(NetworkModule module,
      Provider<TokenData> tokenDataProvider) {
    return new NetworkModule_ProvideSpotifyAuthInterceptorFactory(module, tokenDataProvider);
  }

  public static SpotifyAuthInterceptor provideSpotifyAuthInterceptor(NetworkModule instance,
      TokenData tokenData) {
    return Preconditions.checkNotNull(instance.provideSpotifyAuthInterceptor(tokenData), "Cannot return null from a non-@Nullable @Provides method");
  }
}
