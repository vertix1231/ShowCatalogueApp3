package com.dicoding.bangkit.android.jetpack.showcatalogueapp.di

import android.app.Application
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.CatalogRepository
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.RemoteDataSource
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.local.LocalDataSource
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.local.room.CatalogDao
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.local.room.CatalogDatabase
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.datasource.remote.api.ApiService
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideCatalogDatabase(application: Application): CatalogDatabase =
            CatalogDatabase.getInstance(application)

        @Singleton
        @Provides
        fun provideCatalogDao(catalogDatabase: CatalogDatabase): CatalogDao =
            catalogDatabase.catalogDao()

        @Singleton
        @Provides
        fun provideLocalDataSource(catalogDao: CatalogDao): LocalDataSource =
            LocalDataSource(catalogDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
            RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideCatalogRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource
        ): CatalogRepository = CatalogRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideViewModelFactory(catalogRepository: CatalogRepository): ViewModelFactory =
            ViewModelFactory(catalogRepository)

    }
}