package com.example.sberify.di;

import com.example.sberify.data.api.ISpotifyApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideSpotifyApiServiceFactory implements Factory<ISpotifyApi> {
  private final ApiModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<GsonConverterFactory> gsonProvider;

  public ApiModule_ProvideSpotifyApiServiceFactory(ApiModule module,
      Provider<OkHttpClient> okHttpClientProvider, Provider<GsonConverterFactory> gsonProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public ISpotifyApi get() {
    return provideSpotifyApiService(module, okHttpClientProvider.get(), gsonProvider.get());
  }

  public static ApiModule_ProvideSpotifyApiServiceFactory create(ApiModule module,
      Provider<OkHttpClient> okHttpClientProvider, Provider<GsonConverterFactory> gsonProvider) {
    return new ApiModule_ProvideSpotifyApiServiceFactory(module, okHttpClientProvider, gsonProvider);
  }

  public static ISpotifyApi provideSpotifyApiService(ApiModule instance, OkHttpClient okHttpClient,
      GsonConverterFactory gson) {
    return Preconditions.checkNotNull(instance.provideSpotifyApiService(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
  }
}
