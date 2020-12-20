package com.example.sberify.di;

import com.example.sberify.data.DataConverter;
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
public final class RepositoryModule_ProvideDataConverterFactory implements Factory<DataConverter> {
  private final RepositoryModule module;

  public RepositoryModule_ProvideDataConverterFactory(RepositoryModule module) {
    this.module = module;
  }

  @Override
  public DataConverter get() {
    return provideDataConverter(module);
  }

  public static RepositoryModule_ProvideDataConverterFactory create(RepositoryModule module) {
    return new RepositoryModule_ProvideDataConverterFactory(module);
  }

  public static DataConverter provideDataConverter(RepositoryModule instance) {
    return Preconditions.checkNotNull(instance.provideDataConverter(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
