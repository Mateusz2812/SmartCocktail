package com.smartCocktails.core.di

import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    fun provideInternalLinkNavigator(
        implementations: Set<@JvmSuppressWildcards InternalNavigator>
    ): InternalNavigatorImpl {
        return InternalNavigatorImpl(implementations)
    }
}