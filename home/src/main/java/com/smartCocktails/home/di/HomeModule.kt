package com.smartCocktails.home.di

import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.home.navigator.HomeInternalNavigatorImpl
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
}