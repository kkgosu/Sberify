package com.example.sberify.di

import android.app.Application
import com.example.sberify.SberifyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ActivityModule::class,
            ApiModule::class,
            DbModule::class,
            AndroidSupportInjectionModule::class,
            FragmentModule::class,
            ViewModelModule::class, 
            RepositoryModule::class])

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun apiModule(apiModule: ApiModule): Builder

        @BindsInstance
        fun dbModule(dbModule: DbModule): Builder

        fun build(): AppComponent
    }

    fun inject(appController: SberifyApp)
}