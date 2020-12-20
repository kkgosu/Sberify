package com.kvlg.shared.di;

import com.kvlg.shared.data.SuggestionsRepository;
import com.kvlg.shared.data.db.AppDatabase;
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
public final class ShareModule_ProvideSuggestionsRepositoryFactory implements Factory<SuggestionsRepository> {
  private final Provider<AppDatabase> databaseProvider;

  public ShareModule_ProvideSuggestionsRepositoryFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public SuggestionsRepository get() {
    return provideSuggestionsRepository(databaseProvider.get());
  }

  public static ShareModule_ProvideSuggestionsRepositoryFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new ShareModule_ProvideSuggestionsRepositoryFactory(databaseProvider);
  }

  public static SuggestionsRepository provideSuggestionsRepository(AppDatabase database) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideSuggestionsRepository(database), "Cannot return null from a non-@Nullable @Provides method");
  }
}
