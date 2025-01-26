package com.smartCocktails.core.di

import com.smartCocktails.core.connection.okhttp.OkHttpClientFactory
import com.smartCocktails.core.connection.okhttp.OkHttpClientFactoryImpl
import com.smartCocktails.core.connection.retrofit.ApiServiceFactory
import com.smartCocktails.core.connection.retrofit.ApiServiceFactoryImpl
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoreModule {

    @Binds
    fun provideOkHttpClientFactory(okHttpClientFactory: OkHttpClientFactoryImpl): OkHttpClientFactory

   @Binds
    fun provideApiService(apiServiceImpl: ApiServiceFactoryImpl): ApiServiceFactory

    companion object{
        @Provides
        fun provideInternalLinkNavigator(
            implementations: Set<@JvmSuppressWildcards InternalNavigator>
        ): InternalNavigatorImpl {
            return InternalNavigatorImpl(implementations)
        }
    }

}