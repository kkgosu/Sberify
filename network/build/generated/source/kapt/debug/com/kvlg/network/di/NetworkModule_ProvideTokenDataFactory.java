package com.kvlg.network.di;

import android.content.Context;
import com.kvlg.network.TokenData;
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
public final class NetworkModule_ProvideTokenDataFactory implements Factory<TokenData> {
  private final NetworkModule module;

  private final Provider<Context> contextProvider;

  public NetworkModule_ProvideTokenDataFactory(NetworkModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public TokenData get() {
    return provideTokenData(module, contextProvider.get());
  }

  public static NetworkModule_ProvideTokenDataFactory create(NetworkModule module,
      Provider<Context> contextProvider) {
    return new NetworkModule_ProvideTokenDataFactory(module, contextProvider);
  }

  public static TokenData provideTokenData(NetworkModule instance, Context context) {
    return Preconditions.checkNotNull(instance.provideTokenData(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
