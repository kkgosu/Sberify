package com.example.sberify.di;

import com.example.sberify.data.DbConverter;
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
public final class RepositoryModule_ProvideDbConverterFactory implements Factory<DbConverter> {
  private final RepositoryModule module;

  public RepositoryModule_ProvideDbConverterFactory(RepositoryModule module) {
    this.module = module;
  }

  @Override
  public DbConverter get() {
    return provideDbConverter(module);
  }

  public static RepositoryModule_ProvideDbConverterFactory create(RepositoryModule module) {
    return new RepositoryModule_ProvideDbConverterFactory(module);
  }

  public static DbConverter provideDbConverter(RepositoryModule instance) {
    return Preconditions.checkNotNull(instance.provideDbConverter(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
