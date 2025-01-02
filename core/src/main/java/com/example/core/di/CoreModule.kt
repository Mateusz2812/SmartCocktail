package com.example.core.di

import com.example.core.navigator.InternalNavigatorImpl
import com.example.core.navigator.InternalNavigator
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