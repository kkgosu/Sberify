package com.example.sberify.di;

import com.example.sberify.data.DbConverter;
import com.example.sberify.data.db.AppDatabase;
import com.example.sberify.domain.DatabaseRepository;
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
public final class RepositoryModule_ProvideDatabaseRepositoryFactory implements Factory<DatabaseRepository> {
  private final RepositoryModule module;

  private final Provider<AppDatabase> appDatabaseProvider;

  private final Provider<DbConverter> dbConverterProvider;

  public RepositoryModule_ProvideDatabaseRepositoryFactory(RepositoryModule module,
      Provider<AppDatabase> appDatabaseProvider, Provider<DbConverter> dbConverterProvider) {
    this.module = module;
    this.appDatabaseProvider = appDatabaseProvider;
    this.dbConverterProvider = dbConverterProvider;
  }

  @Override
  public DatabaseRepository get() {
    return provideDatabaseRepository(module, appDatabaseProvider.get(), dbConverterProvider.get());
  }

  public static RepositoryModule_ProvideDatabaseRepositoryFactory create(RepositoryModule module,
      Provider<AppDatabase> appDatabaseProvider, Provider<DbConverter> dbConverterProvider) {
    return new RepositoryModule_ProvideDatabaseRepositoryFactory(module, appDatabaseProvider, dbConverterProvider);
  }

  public static DatabaseRepository provideDatabaseRepository(RepositoryModule instance,
      AppDatabase appDatabase, DbConverter dbConverter) {
    return Preconditions.checkNotNull(instance.provideDatabaseRepository(appDatabase, dbConverter), "Cannot return null from a non-@Nullable @Provides method");
  }
}
