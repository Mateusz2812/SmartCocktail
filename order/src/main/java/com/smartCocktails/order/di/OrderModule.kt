package com.smartCocktails.order.di

import com.smartCocktails.core.connection.retrofit.ApiServiceFactory
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.order.navigator.OrderLinkNavigator
import com.smartCocktails.order.service.OrderServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrderModule {

    @Provides
    @Singleton
    fun provideOrderServiceApi(retrofit: ApiServiceFactory): OrderServiceApi{
        return retrofit.createService(OrderServiceApi::class.java)
    }

    @Provides
    @IntoSet
    fun provideOrderLinkNavigator(): InternalNavigator = OrderLinkNavigator()
}