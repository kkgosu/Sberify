package com.kvlg.network.di;

import com.kvlg.network.spotify.SpotifyApi;
import com.kvlg.network.spotify.SpotifyAuthInterceptor;
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
public final class NetworkModule_ProvideSpotifyApiServiceFactory implements Factory<SpotifyApi> {
  private final NetworkModule module;

  private final Provider<SpotifyAuthInterceptor> interceptorProvider;

  private final Provider<GsonConverterFactory> gsonProvider;

  public NetworkModule_ProvideSpotifyApiServiceFactory(NetworkModule module,
      Provider<SpotifyAuthInterceptor> interceptorProvider,
      Provider<GsonConverterFactory> gsonProvider) {
    this.module = module;
    this.interceptorProvider = interceptorProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public SpotifyApi get() {
    return provideSpotifyApiService(module, interceptorProvider.get(), gsonProvider.get());
  }

  public static NetworkModule_ProvideSpotifyApiServiceFactory create(NetworkModule module,
      Provider<SpotifyAuthInterceptor> interceptorProvider,
      Provider<GsonConverterFactory> gsonProvider) {
    return new NetworkModule_ProvideSpotifyApiServiceFactory(module, interceptorProvider, gsonProvider);
  }

  public static SpotifyApi provideSpotifyApiService(NetworkModule instance,
      SpotifyAuthInterceptor interceptor, GsonConverterFactory gson) {
    return Preconditions.checkNotNull(instance.provideSpotifyApiService(interceptor, gson), "Cannot return null from a non-@Nullable @Provides method");
  }
}
