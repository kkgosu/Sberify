package com.example.sberify.di;

import com.example.sberify.data.api.GeniusAuthInterceptor;
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
public final class ApiModule_ProvideGeniusInterceptorFactory implements Factory<GeniusAuthInterceptor> {
  private final ApiModule module;

  private final Provider<TokenData> tokenDataProvider;

  public ApiModule_ProvideGeniusInterceptorFactory(ApiModule module,
      Provider<TokenData> tokenDataProvider) {
    this.module = module;
    this.tokenDataProvider = tokenDataProvider;
  }

  @Override
  public GeniusAuthInterceptor get() {
    return provideGeniusInterceptor(module, tokenDataProvider.get());
  }

  public static ApiModule_ProvideGeniusInterceptorFactory create(ApiModule module,
      Provider<TokenData> tokenDataProvider) {
    return new ApiModule_ProvideGeniusInterceptorFactory(module, tokenDataProvider);
  }

  public static GeniusAuthInterceptor provideGeniusInterceptor(ApiModule instance,
      TokenData tokenData) {
    return Preconditions.checkNotNull(instance.provideGeniusInterceptor(tokenData), "Cannot return null from a non-@Nullable @Provides method");
  }
}
