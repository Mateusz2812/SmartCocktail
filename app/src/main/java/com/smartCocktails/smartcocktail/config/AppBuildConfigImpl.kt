package com.smartCocktails.smartcocktail.config

import com.smartCocktails.core.build.AppBuildConfig
import com.smartCocktails.smartcocktail.BuildConfig
import javax.inject.Inject

class AppBuildConfigImpl @Inject constructor() : AppBuildConfig {
    override fun SERVER_URL(): String {
        return BuildConfig.SERVER_URL
    }

    override fun IS_PROD(): Boolean {
        return BuildConfig.IS_PROD
    }
}