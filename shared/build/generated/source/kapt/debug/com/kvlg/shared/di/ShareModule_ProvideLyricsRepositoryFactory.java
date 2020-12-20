package com.kvlg.shared.di;

import com.kvlg.network.genius.GeniusApi;
import com.kvlg.network.genius.GeniusParser;
import com.kvlg.shared.data.LyricsRepository;
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
public final class ShareModule_ProvideLyricsRepositoryFactory implements Factory<LyricsRepository> {
  private final Provider<AppDatabase> databaseProvider;

  private final Provider<GeniusApi> geniusApiProvider;

  private final Provider<GeniusParser> geniusParserProvider;

  public ShareModule_ProvideLyricsRepositoryFactory(Provider<AppDatabase> databaseProvider,
      Provider<GeniusApi> geniusApiProvider, Provider<GeniusParser> geniusParserProvider) {
    this.databaseProvider = databaseProvider;
    this.geniusApiProvider = geniusApiProvider;
    this.geniusParserProvider = geniusParserProvider;
  }

  @Override
  public LyricsRepository get() {
    return provideLyricsRepository(databaseProvider.get(), geniusApiProvider.get(), geniusParserProvider.get());
  }

  public static ShareModule_ProvideLyricsRepositoryFactory create(
      Provider<AppDatabase> databaseProvider, Provider<GeniusApi> geniusApiProvider,
      Provider<GeniusParser> geniusParserProvider) {
    return new ShareModule_ProvideLyricsRepositoryFactory(databaseProvider, geniusApiProvider, geniusParserProvider);
  }

  public static LyricsRepository provideLyricsRepository(AppDatabase database, GeniusApi geniusApi,
      GeniusParser geniusParser) {
    return Preconditions.checkNotNull(ShareModule.INSTANCE.provideLyricsRepository(database, geniusApi, geniusParser), "Cannot return null from a non-@Nullable @Provides method");
  }
}
