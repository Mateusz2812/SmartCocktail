package com.smartCocktails.core.build

import javax.inject.Inject

interface AppBuildConfig {
    fun SERVER_URL(): String
}