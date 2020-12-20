package com.kvlg.network.di;

import com.kvlg.network.spotify.DataConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideDataConverterFactory implements Factory<DataConverter> {
  private final NetworkModule module;

  public NetworkModule_ProvideDataConverterFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public DataConverter get() {
    return provideDataConverter(module);
  }

  public static NetworkModule_ProvideDataConverterFactory create(NetworkModule module) {
    return new NetworkModule_ProvideDataConverterFactory(module);
  }

  public static DataConverter provideDataConverter(NetworkModule instance) {
    return Preconditions.checkNotNull(instance.provideDataConverter(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
