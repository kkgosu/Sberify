package com.example.sberify.di;

import com.example.sberify.data.ResponseConverter;
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
public final class RepositoryModule_ProvideResponseConverterFactory implements Factory<ResponseConverter> {
  private final RepositoryModule module;

  public RepositoryModule_ProvideResponseConverterFactory(RepositoryModule module) {
    this.module = module;
  }

  @Override
  public ResponseConverter get() {
    return provideResponseConverter(module);
  }

  public static RepositoryModule_ProvideResponseConverterFactory create(RepositoryModule module) {
    return new RepositoryModule_ProvideResponseConverterFactory(module);
  }

  public static ResponseConverter provideResponseConverter(RepositoryModule instance) {
    return Preconditions.checkNotNull(instance.provideResponseConverter(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
