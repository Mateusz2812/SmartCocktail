package com.smartCocktails.home.di

import com.smartCocktails.core.connection.retrofit.ApiServiceFactory
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.home.navigator.HomeInternalNavigatorImpl
import com.smartCocktails.home.service.HomeServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {

    @Provides
    @IntoSet
    fun provideInternalNavigator(): InternalNavigator = HomeInternalNavigatorImpl()


   @Provides
    fun provideHomeServiceApi(serviceApi: ApiServiceFactory): HomeServiceApi {
        return serviceApi.createService(HomeServiceApi::class.java)
    }
}