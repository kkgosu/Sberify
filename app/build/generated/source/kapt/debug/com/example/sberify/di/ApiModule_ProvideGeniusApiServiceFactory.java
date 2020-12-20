package com.example.sberify.di;

import com.example.sberify.data.api.IGeniusApi;
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
public final class ApiModule_ProvideGeniusApiServiceFactory implements Factory<IGeniusApi> {
  private final ApiModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<GsonConverterFactory> gsonProvider;

  public ApiModule_ProvideGeniusApiServiceFactory(ApiModule module,
      Provider<OkHttpClient> okHttpClientProvider, Provider<GsonConverterFactory> gsonProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public IGeniusApi get() {
    return provideGeniusApiService(module, okHttpClientProvider.get(), gsonProvider.get());
  }

  public static ApiModule_ProvideGeniusApiServiceFactory create(ApiModule module,
      Provider<OkHttpClient> okHttpClientProvider, Provider<GsonConverterFactory> gsonProvider) {
    return new ApiModule_ProvideGeniusApiServiceFactory(module, okHttpClientProvider, gsonProvider);
  }

  public static IGeniusApi provideGeniusApiService(ApiModule instance, OkHttpClient okHttpClient,
      GsonConverterFactory gson) {
    return Preconditions.checkNotNull(instance.provideGeniusApiService(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
  }
}
