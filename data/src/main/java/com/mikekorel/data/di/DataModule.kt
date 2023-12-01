package com.mikekorel.data.di

import com.mikekorel.data.repository.SportsRepository
import com.mikekorel.data.repository.SportsRepositoryImpl
import com.mikekorel.network.NetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideRepository(sportsRepositoryImpl: SportsRepositoryImpl): SportsRepository

}