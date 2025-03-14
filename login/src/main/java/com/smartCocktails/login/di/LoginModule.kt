package com.smartCocktails.login.di

import com.smartCocktails.core.navigator.CodesNavigator
import com.smartCocktails.login.navigator.LoginCodesNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Provides
    @IntoSet
    fun provideInternalNavigator(): CodesNavigator = LoginCodesNavigatorImpl()
}