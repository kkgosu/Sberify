package com.kvlg.network.di;

import com.kvlg.network.genius.GeniusParser;
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
public final class NetworkModule_ProvideGeniusParserFactory implements Factory<GeniusParser> {
  private final NetworkModule module;

  public NetworkModule_ProvideGeniusParserFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public GeniusParser get() {
    return provideGeniusParser(module);
  }

  public static NetworkModule_ProvideGeniusParserFactory create(NetworkModule module) {
    return new NetworkModule_ProvideGeniusParserFactory(module);
  }

  public static GeniusParser provideGeniusParser(NetworkModule instance) {
    return Preconditions.checkNotNull(instance.provideGeniusParser(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
