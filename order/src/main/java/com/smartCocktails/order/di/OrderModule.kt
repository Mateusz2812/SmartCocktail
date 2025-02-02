package com.smartCocktails.order.di

import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.order.navigator.OrderLinkNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
class OrderModule {

    @Provides
    @IntoSet
    fun provideOrderLinkNavigator(): InternalNavigator = OrderLinkNavigator()
}