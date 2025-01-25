package com.smartCocktails.core_api.di

import com.smartCocktails.core.connection.retrofit.AppRetrofitImpl
import com.smartCocktails.core_api.service.CoreApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreApiModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: AppRetrofitImpl): CoreApiService {
        return retrofit.createService(CoreApiService::class.java)
    }
}