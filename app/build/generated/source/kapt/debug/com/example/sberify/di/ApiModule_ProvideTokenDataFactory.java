package com.example.sberify.di;

import android.content.Context;
import com.example.sberify.domain.TokenData;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideTokenDataFactory implements Factory<TokenData> {
  private final ApiModule module;

  private final Provider<Context> contextProvider;

  public ApiModule_ProvideTokenDataFactory(ApiModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public TokenData get() {
    return provideTokenData(module, contextProvider.get());
  }

  public static ApiModule_ProvideTokenDataFactory create(ApiModule module,
      Provider<Context> contextProvider) {
    return new ApiModule_ProvideTokenDataFactory(module, contextProvider);
  }

  public static TokenData provideTokenData(ApiModule instance, Context context) {
    return Preconditions.checkNotNull(instance.provideTokenData(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
