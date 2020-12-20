package com.example.sberify.di;

import com.example.sberify.data.api.SpotifyAuthInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideSpotifyOkHttpClientFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  private final Provider<SpotifyAuthInterceptor> interceptorProvider;

  public ApiModule_ProvideSpotifyOkHttpClientFactory(ApiModule module,
      Provider<SpotifyAuthInterceptor> interceptorProvider) {
    this.module = module;
    this.interceptorProvider = interceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideSpotifyOkHttpClient(module, interceptorProvider.get());
  }

  public static ApiModule_ProvideSpotifyOkHttpClientFactory create(ApiModule module,
      Provider<SpotifyAuthInterceptor> interceptorProvider) {
    return new ApiModule_ProvideSpotifyOkHttpClientFactory(module, interceptorProvider);
  }

  public static OkHttpClient provideSpotifyOkHttpClient(ApiModule instance,
      SpotifyAuthInterceptor interceptor) {
    return Preconditions.checkNotNull(instance.provideSpotifyOkHttpClient(interceptor), "Cannot return null from a non-@Nullable @Provides method");
  }
}
