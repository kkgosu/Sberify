package com.kvlg.network.di;

import com.kvlg.network.genius.GeniusApi;
import com.kvlg.network.genius.GeniusAuthInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideGeniusApiServiceFactory implements Factory<GeniusApi> {
  private final NetworkModule module;

  private final Provider<GeniusAuthInterceptor> interceptorProvider;

  private final Provider<GsonConverterFactory> gsonProvider;

  public NetworkModule_ProvideGeniusApiServiceFactory(NetworkModule module,
      Provider<GeniusAuthInterceptor> interceptorProvider,
      Provider<GsonConverterFactory> gsonProvider) {
    this.module = module;
    this.interceptorProvider = interceptorProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public GeniusApi get() {
    return provideGeniusApiService(module, interceptorProvider.get(), gsonProvider.get());
  }

  public static NetworkModule_ProvideGeniusApiServiceFactory create(NetworkModule module,
      Provider<GeniusAuthInterceptor> interceptorProvider,
      Provider<GsonConverterFactory> gsonProvider) {
    return new NetworkModule_ProvideGeniusApiServiceFactory(module, interceptorProvider, gsonProvider);
  }

  public static GeniusApi provideGeniusApiService(NetworkModule instance,
      GeniusAuthInterceptor interceptor, GsonConverterFactory gson) {
    return Preconditions.checkNotNull(instance.provideGeniusApiService(interceptor, gson), "Cannot return null from a non-@Nullable @Provides method");
  }
}
