package com.smartCocktails.order.di

import com.smartCocktails.core.connection.retrofit.ApiServiceFactory
import com.smartCocktails.core.navigator.CodesNavigator
import com.smartCocktails.order.navigator.OrderLinkCodesNavigator
import com.smartCocktails.order.service.OrderServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
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
    fun provideOrderLinkNavigator(): CodesNavigator = OrderLinkCodesNavigator()
}