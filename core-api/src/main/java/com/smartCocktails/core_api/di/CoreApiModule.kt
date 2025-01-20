package com.smartCocktails.core_api.di

import com.smartCocktails.core.connection.retrofit.AppRetrofitImpl
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
    fun provideApiService(retrofit: AppRetrofitImpl): com.smartCocktails.core_api.service.CoreApiService {
        return retrofit.createService(com.smartCocktails.core_api.service.CoreApiService::class.java)
    }
}