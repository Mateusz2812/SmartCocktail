package com.smartCocktails.core_api.di

import com.smartCocktails.core.connection.retrofit.ApiServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreApiModule {

    @Provides
    @Singleton
    fun provideCoreApiService(apiServiceFactory: ApiServiceFactory): com.smartCocktails.core_api.service.CoreApiService {
        return apiServiceFactory.createService(com.smartCocktails.core_api.service.CoreApiService::class.java)
    }

}