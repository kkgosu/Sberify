package com.example.sberify.di;

import com.example.sberify.data.GeniusParser;
import com.example.sberify.data.api.IGeniusApi;
import com.example.sberify.data.db.AppDatabase;
import com.example.sberify.domain.IGeniusRepository;
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
public final class RepositoryModule_ProvideGeniusRepositoryFactory implements Factory<IGeniusRepository> {
  private final RepositoryModule module;

  private final Provider<GeniusParser> geniusParserProvider;

  private final Provider<AppDatabase> appDatabaseProvider;

  private final Provider<IGeniusApi> geniusApiProvider;

  public RepositoryModule_ProvideGeniusRepositoryFactory(RepositoryModule module,
      Provider<GeniusParser> geniusParserProvider, Provider<AppDatabase> appDatabaseProvider,
      Provider<IGeniusApi> geniusApiProvider) {
    this.module = module;
    this.geniusParserProvider = geniusParserProvider;
    this.appDatabaseProvider = appDatabaseProvider;
    this.geniusApiProvider = geniusApiProvider;
  }

  @Override
  public IGeniusRepository get() {
    return provideGeniusRepository(module, geniusParserProvider.get(), appDatabaseProvider.get(), geniusApiProvider.get());
  }

  public static RepositoryModule_ProvideGeniusRepositoryFactory create(RepositoryModule module,
      Provider<GeniusParser> geniusParserProvider, Provider<AppDatabase> appDatabaseProvider,
      Provider<IGeniusApi> geniusApiProvider) {
    return new RepositoryModule_ProvideGeniusRepositoryFactory(module, geniusParserProvider, appDatabaseProvider, geniusApiProvider);
  }

  public static IGeniusRepository provideGeniusRepository(RepositoryModule instance,
      GeniusParser geniusParser, AppDatabase appDatabase, IGeniusApi geniusApi) {
    return Preconditions.checkNotNull(instance.provideGeniusRepository(geniusParser, appDatabase, geniusApi), "Cannot return null from a non-@Nullable @Provides method");
  }
}
