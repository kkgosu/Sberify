package com.example.sberify;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.sberify.data.GeniusParser;
import com.example.sberify.data.ResponseConverter;
import com.example.sberify.data.api.GeniusAuthInterceptor;
import com.example.sberify.data.api.IGeniusApi;
import com.example.sberify.data.api.ISpotifyApi;
import com.example.sberify.data.api.SpotifyAuthInterceptor;
import com.example.sberify.data.db.AppDatabase;
import com.example.sberify.di.ApiModule;
import com.example.sberify.di.ApiModule_ProvideGeniusApiServiceFactory;
import com.example.sberify.di.ApiModule_ProvideGeniusInterceptorFactory;
import com.example.sberify.di.ApiModule_ProvideGeniusOkHttpClientFactory;
import com.example.sberify.di.ApiModule_ProvideGsonConverterFactoryFactory;
import com.example.sberify.di.ApiModule_ProvideSpotifyApiServiceFactory;
import com.example.sberify.di.ApiModule_ProvideSpotifyInterceptorFactory;
import com.example.sberify.di.ApiModule_ProvideSpotifyOkHttpClientFactory;
import com.example.sberify.di.ApiModule_ProvideTokenDataFactory;
import com.example.sberify.di.DbModule;
import com.example.sberify.di.DbModule_ProvideDatabaseFactory;
import com.example.sberify.di.RepositoryModule;
import com.example.sberify.di.RepositoryModule_ProvideDatabaseRepositoryFactory;
import com.example.sberify.di.RepositoryModule_ProvideDbConverterFactory;
import com.example.sberify.di.RepositoryModule_ProvideGeniusParserFactory;
import com.example.sberify.di.RepositoryModule_ProvideGeniusRepositoryFactory;
import com.example.sberify.di.RepositoryModule_ProvideResponseConverterFactory;
import com.example.sberify.di.RepositoryModule_ProvideSpotifyRepositoryFactory;
import com.example.sberify.domain.DatabaseRepository;
import com.example.sberify.domain.IGeniusRepository;
import com.example.sberify.domain.ISpotifyRepository;
import com.example.sberify.domain.TokenData;
import com.example.sberify.presentation.ui.MainActivity;
import com.example.sberify.presentation.ui.MainActivity_MembersInjector;
import com.example.sberify.presentation.ui.SharedViewModel_AssistedFactory;
import com.example.sberify.presentation.ui.SharedViewModel_AssistedFactory_Factory;
import com.example.sberify.presentation.ui.albuminfo.AlbumDetailsFragment;
import com.example.sberify.presentation.ui.favorite.FavoriteFragment;
import com.example.sberify.presentation.ui.favorite.FavoriteViewModel_AssistedFactory;
import com.example.sberify.presentation.ui.favorite.FavoriteViewModel_AssistedFactory_Factory;
import com.example.sberify.presentation.ui.lyrics.LyricsFragment;
import com.example.sberify.presentation.ui.lyrics.LyricsViewModel_AssistedFactory;
import com.example.sberify.presentation.ui.lyrics.LyricsViewModel_AssistedFactory_Factory;
import com.example.sberify.presentation.ui.newreleases.NewReleasesFragment;
import com.example.sberify.presentation.ui.search.SearchFragment;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerSberifyApp_HiltComponents_ApplicationC extends SberifyApp_HiltComponents.ApplicationC {
  private final ApplicationContextModule applicationContextModule;

  private final ApiModule apiModule;

  private final DbModule dbModule;

  private final RepositoryModule repositoryModule;

  private volatile Object appDatabase = new MemoizedSentinel();

  private volatile Object databaseRepository = new MemoizedSentinel();

  private volatile Provider<DatabaseRepository> provideDatabaseRepositoryProvider;

  private volatile Object responseConverter = new MemoizedSentinel();

  private volatile Object iSpotifyRepository = new MemoizedSentinel();

  private volatile Provider<ISpotifyRepository> provideSpotifyRepositoryProvider;

  private volatile Object geniusParser = new MemoizedSentinel();

  private volatile Object iGeniusRepository = new MemoizedSentinel();

  private volatile Provider<IGeniusRepository> provideGeniusRepositoryProvider;

  private DaggerSberifyApp_HiltComponents_ApplicationC(
      ApplicationContextModule applicationContextModuleParam, DbModule dbModuleParam,
      RepositoryModule repositoryModuleParam, ApiModule apiModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
    this.apiModule = apiModuleParam;
    this.dbModule = dbModuleParam;
    this.repositoryModule = repositoryModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private AppDatabase getAppDatabase() {
    Object local = appDatabase;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = appDatabase;
        if (local instanceof MemoizedSentinel) {
          local = DbModule_ProvideDatabaseFactory.provideDatabase(dbModule, ApplicationContextModule_ProvideApplicationFactory.provideApplication(applicationContextModule));
          appDatabase = DoubleCheck.reentrantCheck(appDatabase, local);
        }
      }
    }
    return (AppDatabase) local;
  }

  private DatabaseRepository getDatabaseRepository() {
    Object local = databaseRepository;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = databaseRepository;
        if (local instanceof MemoizedSentinel) {
          local = RepositoryModule_ProvideDatabaseRepositoryFactory.provideDatabaseRepository(repositoryModule, getAppDatabase(), RepositoryModule_ProvideDbConverterFactory.provideDbConverter(repositoryModule));
          databaseRepository = DoubleCheck.reentrantCheck(databaseRepository, local);
        }
      }
    }
    return (DatabaseRepository) local;
  }

  private Provider<DatabaseRepository> getDatabaseRepositoryProvider() {
    Object local = provideDatabaseRepositoryProvider;
    if (local == null) {
      local = new SwitchingProvider<>(0);
      provideDatabaseRepositoryProvider = (Provider<DatabaseRepository>) local;
    }
    return (Provider<DatabaseRepository>) local;
  }

  private TokenData getTokenData() {
    return ApiModule_ProvideTokenDataFactory.provideTokenData(apiModule, ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
  }

  private SpotifyAuthInterceptor getSpotifyAuthInterceptor() {
    return ApiModule_ProvideSpotifyInterceptorFactory.provideSpotifyInterceptor(apiModule, getTokenData());
  }

  private OkHttpClient getSpotifyNetworkOkHttpClient() {
    return ApiModule_ProvideSpotifyOkHttpClientFactory.provideSpotifyOkHttpClient(apiModule, getSpotifyAuthInterceptor());
  }

  private ISpotifyApi getISpotifyApi() {
    return ApiModule_ProvideSpotifyApiServiceFactory.provideSpotifyApiService(apiModule, getSpotifyNetworkOkHttpClient(), ApiModule_ProvideGsonConverterFactoryFactory.provideGsonConverterFactory(apiModule));
  }

  private ResponseConverter getResponseConverter() {
    Object local = responseConverter;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = responseConverter;
        if (local instanceof MemoizedSentinel) {
          local = RepositoryModule_ProvideResponseConverterFactory.provideResponseConverter(repositoryModule);
          responseConverter = DoubleCheck.reentrantCheck(responseConverter, local);
        }
      }
    }
    return (ResponseConverter) local;
  }

  private ISpotifyRepository getISpotifyRepository() {
    Object local = iSpotifyRepository;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = iSpotifyRepository;
        if (local instanceof MemoizedSentinel) {
          local = RepositoryModule_ProvideSpotifyRepositoryFactory.provideSpotifyRepository(repositoryModule, getAppDatabase(), getISpotifyApi(), RepositoryModule_ProvideDbConverterFactory.provideDbConverter(repositoryModule), getResponseConverter());
          iSpotifyRepository = DoubleCheck.reentrantCheck(iSpotifyRepository, local);
        }
      }
    }
    return (ISpotifyRepository) local;
  }

  private Provider<ISpotifyRepository> getISpotifyRepositoryProvider() {
    Object local = provideSpotifyRepositoryProvider;
    if (local == null) {
      local = new SwitchingProvider<>(1);
      provideSpotifyRepositoryProvider = (Provider<ISpotifyRepository>) local;
    }
    return (Provider<ISpotifyRepository>) local;
  }

  private GeniusParser getGeniusParser() {
    Object local = geniusParser;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = geniusParser;
        if (local instanceof MemoizedSentinel) {
          local = RepositoryModule_ProvideGeniusParserFactory.provideGeniusParser(repositoryModule);
          geniusParser = DoubleCheck.reentrantCheck(geniusParser, local);
        }
      }
    }
    return (GeniusParser) local;
  }

  private GeniusAuthInterceptor getGeniusAuthInterceptor() {
    return ApiModule_ProvideGeniusInterceptorFactory.provideGeniusInterceptor(apiModule, getTokenData());
  }

  private OkHttpClient getGeniusNetworkOkHttpClient() {
    return ApiModule_ProvideGeniusOkHttpClientFactory.provideGeniusOkHttpClient(apiModule, getGeniusAuthInterceptor());
  }

  private IGeniusApi getIGeniusApi() {
    return ApiModule_ProvideGeniusApiServiceFactory.provideGeniusApiService(apiModule, getGeniusNetworkOkHttpClient(), ApiModule_ProvideGsonConverterFactoryFactory.provideGsonConverterFactory(apiModule));
  }

  private IGeniusRepository getIGeniusRepository() {
    Object local = iGeniusRepository;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = iGeniusRepository;
        if (local instanceof MemoizedSentinel) {
          local = RepositoryModule_ProvideGeniusRepositoryFactory.provideGeniusRepository(repositoryModule, getGeniusParser(), getAppDatabase(), getIGeniusApi());
          iGeniusRepository = DoubleCheck.reentrantCheck(iGeniusRepository, local);
        }
      }
    }
    return (IGeniusRepository) local;
  }

  private Provider<IGeniusRepository> getIGeniusRepositoryProvider() {
    Object local = provideGeniusRepositoryProvider;
    if (local == null) {
      local = new SwitchingProvider<>(2);
      provideGeniusRepositoryProvider = (Provider<IGeniusRepository>) local;
    }
    return (Provider<IGeniusRepository>) local;
  }

  @Override
  public void injectSberifyApp(SberifyApp sberifyApp) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private DbModule dbModule;

    private RepositoryModule repositoryModule;

    private ApiModule apiModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder dbModule(DbModule dbModule) {
      this.dbModule = Preconditions.checkNotNull(dbModule);
      return this;
    }

    public Builder repositoryModule(RepositoryModule repositoryModule) {
      this.repositoryModule = Preconditions.checkNotNull(repositoryModule);
      return this;
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }

    public SberifyApp_HiltComponents.ApplicationC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (dbModule == null) {
        this.dbModule = new DbModule();
      }
      if (repositoryModule == null) {
        this.repositoryModule = new RepositoryModule();
      }
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      return new DaggerSberifyApp_HiltComponents_ApplicationC(applicationContextModule, dbModule, repositoryModule, apiModule);
    }
  }

  private final class ActivityRetainedCBuilder implements SberifyApp_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public SberifyApp_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends SberifyApp_HiltComponents.ActivityRetainedC {
    private ActivityRetainedCImpl() {

    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    private final class ActivityCBuilder implements SberifyApp_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public SberifyApp_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends SberifyApp_HiltComponents.ActivityC {
      private final Activity activity;

      private volatile Provider<FavoriteViewModel_AssistedFactory> favoriteViewModel_AssistedFactoryProvider;

      private volatile Provider<LyricsViewModel_AssistedFactory> lyricsViewModel_AssistedFactoryProvider;

      private volatile Provider<TokenData> provideTokenDataProvider;

      private volatile Provider<SharedViewModel_AssistedFactory> sharedViewModel_AssistedFactoryProvider;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private TokenData getTokenData() {
        return ApiModule_ProvideTokenDataFactory.provideTokenData(DaggerSberifyApp_HiltComponents_ApplicationC.this.apiModule, ApplicationContextModule_ProvideContextFactory.provideContext(DaggerSberifyApp_HiltComponents_ApplicationC.this.applicationContextModule));
      }

      private FavoriteViewModel_AssistedFactory getFavoriteViewModel_AssistedFactory() {
        return FavoriteViewModel_AssistedFactory_Factory.newInstance(DaggerSberifyApp_HiltComponents_ApplicationC.this.getDatabaseRepositoryProvider());
      }

      private Provider<FavoriteViewModel_AssistedFactory> getFavoriteViewModel_AssistedFactoryProvider(
          ) {
        Object local = favoriteViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          favoriteViewModel_AssistedFactoryProvider = (Provider<FavoriteViewModel_AssistedFactory>) local;
        }
        return (Provider<FavoriteViewModel_AssistedFactory>) local;
      }

      private LyricsViewModel_AssistedFactory getLyricsViewModel_AssistedFactory() {
        return LyricsViewModel_AssistedFactory_Factory.newInstance(DaggerSberifyApp_HiltComponents_ApplicationC.this.getDatabaseRepositoryProvider());
      }

      private Provider<LyricsViewModel_AssistedFactory> getLyricsViewModel_AssistedFactoryProvider(
          ) {
        Object local = lyricsViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(1);
          lyricsViewModel_AssistedFactoryProvider = (Provider<LyricsViewModel_AssistedFactory>) local;
        }
        return (Provider<LyricsViewModel_AssistedFactory>) local;
      }

      private Provider<TokenData> getTokenDataProvider() {
        Object local = provideTokenDataProvider;
        if (local == null) {
          local = new SwitchingProvider<>(3);
          provideTokenDataProvider = (Provider<TokenData>) local;
        }
        return (Provider<TokenData>) local;
      }

      private SharedViewModel_AssistedFactory getSharedViewModel_AssistedFactory() {
        return SharedViewModel_AssistedFactory_Factory.newInstance(DaggerSberifyApp_HiltComponents_ApplicationC.this.getISpotifyRepositoryProvider(), DaggerSberifyApp_HiltComponents_ApplicationC.this.getIGeniusRepositoryProvider(), DaggerSberifyApp_HiltComponents_ApplicationC.this.getDatabaseRepositoryProvider(), getTokenDataProvider());
      }

      private Provider<SharedViewModel_AssistedFactory> getSharedViewModel_AssistedFactoryProvider(
          ) {
        Object local = sharedViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(2);
          sharedViewModel_AssistedFactoryProvider = (Provider<SharedViewModel_AssistedFactory>) local;
        }
        return (Provider<SharedViewModel_AssistedFactory>) local;
      }

      private Map<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>> getMapOfStringAndProviderOfViewModelAssistedFactoryOf(
          ) {
        return MapBuilder.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>newMapBuilder(3).put("com.example.sberify.presentation.ui.favorite.FavoriteViewModel", (Provider) getFavoriteViewModel_AssistedFactoryProvider()).put("com.example.sberify.presentation.ui.lyrics.LyricsViewModel", (Provider) getLyricsViewModel_AssistedFactoryProvider()).put("com.example.sberify.presentation.ui.SharedViewModel", (Provider) getSharedViewModel_AssistedFactoryProvider()).build();
      }

      private ViewModelProvider.Factory getProvideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerSberifyApp_HiltComponents_ApplicationC.this.applicationContextModule), getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
        injectMainActivity2(mainActivity);
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private MainActivity injectMainActivity2(MainActivity instance) {
        MainActivity_MembersInjector.injectTokenData(instance, getTokenData());
        return instance;
      }

      private final class FragmentCBuilder implements SberifyApp_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public SberifyApp_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends SberifyApp_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory getProvideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerSberifyApp_HiltComponents_ApplicationC.this.applicationContextModule), ActivityCImpl.this.getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
        }

        @Override
        public void injectAlbumDetailsFragment(AlbumDetailsFragment albumDetailsFragment) {
        }

        @Override
        public void injectFavoriteFragment(FavoriteFragment favoriteFragment) {
        }

        @Override
        public void injectLyricsFragment(LyricsFragment lyricsFragment) {
        }

        @Override
        public void injectNewReleasesFragment(NewReleasesFragment newReleasesFragment) {
        }

        @Override
        public void injectSearchFragment(SearchFragment searchFragment) {
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements SberifyApp_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public SberifyApp_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends SberifyApp_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements SberifyApp_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public SberifyApp_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends SberifyApp_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.example.sberify.presentation.ui.favorite.FavoriteViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getFavoriteViewModel_AssistedFactory();

            case 1: // com.example.sberify.presentation.ui.lyrics.LyricsViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getLyricsViewModel_AssistedFactory();

            case 2: // com.example.sberify.presentation.ui.SharedViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getSharedViewModel_AssistedFactory();

            case 3: // com.example.sberify.domain.TokenData 
            return (T) ActivityCImpl.this.getTokenData();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements SberifyApp_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public SberifyApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends SberifyApp_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }

  private final class SwitchingProvider<T> implements Provider<T> {
    private final int id;

    SwitchingProvider(int id) {
      this.id = id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
      switch (id) {
        case 0: // com.example.sberify.domain.DatabaseRepository 
        return (T) DaggerSberifyApp_HiltComponents_ApplicationC.this.getDatabaseRepository();

        case 1: // com.example.sberify.domain.ISpotifyRepository 
        return (T) DaggerSberifyApp_HiltComponents_ApplicationC.this.getISpotifyRepository();

        case 2: // com.example.sberify.domain.IGeniusRepository 
        return (T) DaggerSberifyApp_HiltComponents_ApplicationC.this.getIGeniusRepository();

        default: throw new AssertionError(id);
      }
    }
  }
}
