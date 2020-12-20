package com.example.sberify.data.repository;

import com.example.sberify.data.DbConverter;
import com.example.sberify.data.db.AppDatabase;
import dagger.internal.Factory;
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
public final class DatabaseRepositoryImpl_Factory implements Factory<DatabaseRepositoryImpl> {
  private final Provider<AppDatabase> databaseProvider;

  private final Provider<DbConverter> dbConverterProvider;

  public DatabaseRepositoryImpl_Factory(Provider<AppDatabase> databaseProvider,
      Provider<DbConverter> dbConverterProvider) {
    this.databaseProvider = databaseProvider;
    this.dbConverterProvider = dbConverterProvider;
  }

  @Override
  public DatabaseRepositoryImpl get() {
    return newInstance(databaseProvider.get(), dbConverterProvider.get());
  }

  public static DatabaseRepositoryImpl_Factory create(Provider<AppDatabase> databaseProvider,
      Provider<DbConverter> dbConverterProvider) {
    return new DatabaseRepositoryImpl_Factory(databaseProvider, dbConverterProvider);
  }

  public static DatabaseRepositoryImpl newInstance(AppDatabase database, DbConverter dbConverter) {
    return new DatabaseRepositoryImpl(database, dbConverter);
  }
}
