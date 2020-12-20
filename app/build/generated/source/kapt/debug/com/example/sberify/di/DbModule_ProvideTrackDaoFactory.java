package com.example.sberify.di;

import com.example.sberify.data.db.AppDatabase;
import com.example.sberify.data.db.track.TrackDao;
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
public final class DbModule_ProvideTrackDaoFactory implements Factory<TrackDao> {
  private final DbModule module;

  private final Provider<AppDatabase> appDatabaseProvider;

  public DbModule_ProvideTrackDaoFactory(DbModule module,
      Provider<AppDatabase> appDatabaseProvider) {
    this.module = module;
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public TrackDao get() {
    return provideTrackDao(module, appDatabaseProvider.get());
  }

  public static DbModule_ProvideTrackDaoFactory create(DbModule module,
      Provider<AppDatabase> appDatabaseProvider) {
    return new DbModule_ProvideTrackDaoFactory(module, appDatabaseProvider);
  }

  public static TrackDao provideTrackDao(DbModule instance, AppDatabase appDatabase) {
    return Preconditions.checkNotNull(instance.provideTrackDao(appDatabase), "Cannot return null from a non-@Nullable @Provides method");
  }
}
