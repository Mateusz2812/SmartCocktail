package com.example.core.di

import com.example.core.navigator.InternalLinkNavigator
import com.example.core.navigator.InternalNavigator
import com.example.core.navigator.InternalNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    fun provideInternalLinkNavigator(
        implementations: Set<@JvmSuppressWildcards InternalNavigator>
    ): InternalLinkNavigator {
        return InternalLinkNavigator(implementations)
    }
}