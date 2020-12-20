package com.example.sberify.data.repository;

import com.example.sberify.data.GeniusParser;
import com.example.sberify.data.api.IGeniusApi;
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
public final class GeniusRepository_Factory implements Factory<GeniusRepository> {
  private final Provider<GeniusParser> geniusParserProvider;

  private final Provider<AppDatabase> databaseProvider;

  private final Provider<IGeniusApi> geniusApiProvider;

  public GeniusRepository_Factory(Provider<GeniusParser> geniusParserProvider,
      Provider<AppDatabase> databaseProvider, Provider<IGeniusApi> geniusApiProvider) {
    this.geniusParserProvider = geniusParserProvider;
    this.databaseProvider = databaseProvider;
    this.geniusApiProvider = geniusApiProvider;
  }

  @Override
  public GeniusRepository get() {
    return newInstance(geniusParserProvider.get(), databaseProvider.get(), geniusApiProvider.get());
  }

  public static GeniusRepository_Factory create(Provider<GeniusParser> geniusParserProvider,
      Provider<AppDatabase> databaseProvider, Provider<IGeniusApi> geniusApiProvider) {
    return new GeniusRepository_Factory(geniusParserProvider, databaseProvider, geniusApiProvider);
  }

  public static GeniusRepository newInstance(GeniusParser geniusParser, AppDatabase database,
      IGeniusApi geniusApi) {
    return new GeniusRepository(geniusParser, database, geniusApi);
  }
}
