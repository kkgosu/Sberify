package com.example.sberify.di;

import com.example.sberify.data.GeniusParser;
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
public final class RepositoryModule_ProvideGeniusParserFactory implements Factory<GeniusParser> {
  private final RepositoryModule module;

  public RepositoryModule_ProvideGeniusParserFactory(RepositoryModule module) {
    this.module = module;
  }

  @Override
  public GeniusParser get() {
    return provideGeniusParser(module);
  }

  public static RepositoryModule_ProvideGeniusParserFactory create(RepositoryModule module) {
    return new RepositoryModule_ProvideGeniusParserFactory(module);
  }

  public static GeniusParser provideGeniusParser(RepositoryModule instance) {
    return Preconditions.checkNotNull(instance.provideGeniusParser(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
