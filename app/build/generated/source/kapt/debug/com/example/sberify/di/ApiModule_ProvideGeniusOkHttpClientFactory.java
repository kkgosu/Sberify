package com.example.sberify.di;

import com.example.sberify.data.api.GeniusAuthInterceptor;
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
public final class ApiModule_ProvideGeniusOkHttpClientFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  private final Provider<GeniusAuthInterceptor> interceptorProvider;

  public ApiModule_ProvideGeniusOkHttpClientFactory(ApiModule module,
      Provider<GeniusAuthInterceptor> interceptorProvider) {
    this.module = module;
    this.interceptorProvider = interceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideGeniusOkHttpClient(module, interceptorProvider.get());
  }

  public static ApiModule_ProvideGeniusOkHttpClientFactory create(ApiModule module,
      Provider<GeniusAuthInterceptor> interceptorProvider) {
    return new ApiModule_ProvideGeniusOkHttpClientFactory(module, interceptorProvider);
  }

  public static OkHttpClient provideGeniusOkHttpClient(ApiModule instance,
      GeniusAuthInterceptor interceptor) {
    return Preconditions.checkNotNull(instance.provideGeniusOkHttpClient(interceptor), "Cannot return null from a non-@Nullable @Provides method");
  }
}
