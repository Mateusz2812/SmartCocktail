package com.smartCocktails.smartcocktail.di

import com.smartCocktails.core.build.AppBuildConfig
import com.smartCocktails.smartcocktail.config.AppBuildConfigImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun bindAppBuildConfig(): AppBuildConfig {
        return AppBuildConfigImpl()
    }
}