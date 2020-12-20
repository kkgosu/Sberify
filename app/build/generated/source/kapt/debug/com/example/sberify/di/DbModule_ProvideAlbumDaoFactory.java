package com.example.sberify.di;

import com.example.sberify.data.db.AppDatabase;
import com.example.sberify.data.db.album.AlbumDao;
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
public final class DbModule_ProvideAlbumDaoFactory implements Factory<AlbumDao> {
  private final DbModule module;

  private final Provider<AppDatabase> appDatabaseProvider;

  public DbModule_ProvideAlbumDaoFactory(DbModule module,
      Provider<AppDatabase> appDatabaseProvider) {
    this.module = module;
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public AlbumDao get() {
    return provideAlbumDao(module, appDatabaseProvider.get());
  }

  public static DbModule_ProvideAlbumDaoFactory create(DbModule module,
      Provider<AppDatabase> appDatabaseProvider) {
    return new DbModule_ProvideAlbumDaoFactory(module, appDatabaseProvider);
  }

  public static AlbumDao provideAlbumDao(DbModule instance, AppDatabase appDatabase) {
    return Preconditions.checkNotNull(instance.provideAlbumDao(appDatabase), "Cannot return null from a non-@Nullable @Provides method");
  }
}
