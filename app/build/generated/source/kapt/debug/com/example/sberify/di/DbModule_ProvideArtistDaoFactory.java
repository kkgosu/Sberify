package com.example.sberify.di;

import com.example.sberify.data.db.AppDatabase;
import com.example.sberify.data.db.artists.ArtistDao;
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
public final class DbModule_ProvideArtistDaoFactory implements Factory<ArtistDao> {
  private final DbModule module;

  private final Provider<AppDatabase> appDatabaseProvider;

  public DbModule_ProvideArtistDaoFactory(DbModule module,
      Provider<AppDatabase> appDatabaseProvider) {
    this.module = module;
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public ArtistDao get() {
    return provideArtistDao(module, appDatabaseProvider.get());
  }

  public static DbModule_ProvideArtistDaoFactory create(DbModule module,
      Provider<AppDatabase> appDatabaseProvider) {
    return new DbModule_ProvideArtistDaoFactory(module, appDatabaseProvider);
  }

  public static ArtistDao provideArtistDao(DbModule instance, AppDatabase appDatabase) {
    return Preconditions.checkNotNull(instance.provideArtistDao(appDatabase), "Cannot return null from a non-@Nullable @Provides method");
  }
}
