package com.example.sberify.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideGsonConverterFactoryFactory implements Factory<GsonConverterFactory> {
  private final ApiModule module;

  public ApiModule_ProvideGsonConverterFactoryFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public GsonConverterFactory get() {
    return provideGsonConverterFactory(module);
  }

  public static ApiModule_ProvideGsonConverterFactoryFactory create(ApiModule module) {
    return new ApiModule_ProvideGsonConverterFactoryFactory(module);
  }

  public static GsonConverterFactory provideGsonConverterFactory(ApiModule instance) {
    return Preconditions.checkNotNull(instance.provideGsonConverterFactory(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
