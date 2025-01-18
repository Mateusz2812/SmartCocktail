package com.smartCocktails.core.di

import com.smartCocktails.core.connection.retrofit.AppRetrofitServiceImpl
import com.smartCocktails.core.connection.retrofit.AppServiceApi
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.core.service.BaseApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    fun provideInternalLinkNavigator(
        implementations: Set<@JvmSuppressWildcards InternalNavigator>
    ): InternalNavigatorImpl {
        return InternalNavigatorImpl(implementations)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: AppRetrofitServiceImpl): BaseApiService {
        return retrofit.createService().create(BaseApiService::class.java)
    }
}