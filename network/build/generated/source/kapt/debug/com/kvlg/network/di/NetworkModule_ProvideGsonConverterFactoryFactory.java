package com.kvlg.network.di;

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
public final class NetworkModule_ProvideGsonConverterFactoryFactory implements Factory<GsonConverterFactory> {
  private final NetworkModule module;

  public NetworkModule_ProvideGsonConverterFactoryFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public GsonConverterFactory get() {
    return provideGsonConverterFactory(module);
  }

  public static NetworkModule_ProvideGsonConverterFactoryFactory create(NetworkModule module) {
    return new NetworkModule_ProvideGsonConverterFactoryFactory(module);
  }

  public static GsonConverterFactory provideGsonConverterFactory(NetworkModule instance) {
    return Preconditions.checkNotNull(instance.provideGsonConverterFactory(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
