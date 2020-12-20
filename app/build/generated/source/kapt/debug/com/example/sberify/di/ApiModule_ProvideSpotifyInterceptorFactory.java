package com.example.sberify.di;

import com.example.sberify.data.api.SpotifyAuthInterceptor;
import com.example.sberify.domain.TokenData;
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
public final class ApiModule_ProvideSpotifyInterceptorFactory implements Factory<SpotifyAuthInterceptor> {
  private final ApiModule module;

  private final Provider<TokenData> tokenDataProvider;

  public ApiModule_ProvideSpotifyInterceptorFactory(ApiModule module,
      Provider<TokenData> tokenDataProvider) {
    this.module = module;
    this.tokenDataProvider = tokenDataProvider;
  }

  @Override
  public SpotifyAuthInterceptor get() {
    return provideSpotifyInterceptor(module, tokenDataProvider.get());
  }

  public static ApiModule_ProvideSpotifyInterceptorFactory create(ApiModule module,
      Provider<TokenData> tokenDataProvider) {
    return new ApiModule_ProvideSpotifyInterceptorFactory(module, tokenDataProvider);
  }

  public static SpotifyAuthInterceptor provideSpotifyInterceptor(ApiModule instance,
      TokenData tokenData) {
    return Preconditions.checkNotNull(instance.provideSpotifyInterceptor(tokenData), "Cannot return null from a non-@Nullable @Provides method");
  }
}
