package com.smartCocktails.home.model

import android.content.Context

sealed class HomeIntent {
    data class LogOut(val context: Context): HomeIntent()
    data object ShowCocktails: HomeIntent()
    data object GoToOrderCocktail: HomeIntent()
    data object GoToConfigureCocktail: HomeIntent()
}