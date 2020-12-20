package com.example.sberify.di;

import android.app.Application;
import com.example.sberify.data.db.AppDatabase;
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
public final class DbModule_ProvideDatabaseFactory implements Factory<AppDatabase> {
  private final DbModule module;

  private final Provider<Application> applicationProvider;

  public DbModule_ProvideDatabaseFactory(DbModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public AppDatabase get() {
    return provideDatabase(module, applicationProvider.get());
  }

  public static DbModule_ProvideDatabaseFactory create(DbModule module,
      Provider<Application> applicationProvider) {
    return new DbModule_ProvideDatabaseFactory(module, applicationProvider);
  }

  public static AppDatabase provideDatabase(DbModule instance, Application application) {
    return Preconditions.checkNotNull(instance.provideDatabase(application), "Cannot return null from a non-@Nullable @Provides method");
  }
}
