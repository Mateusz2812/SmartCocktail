package com.smartCocktails.home.model

import android.content.Context

sealed class HomeIntent {
    data class LogOut(val context: Context): HomeIntent()
    data object LoadAllCocktails: HomeIntent()
    data class ShowCocktail(val name: String): HomeIntent()
}