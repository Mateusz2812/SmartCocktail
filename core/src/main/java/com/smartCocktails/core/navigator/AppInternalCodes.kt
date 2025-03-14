package com.smartCocktails.core.navigator

enum class AppInternalCodes {
    HOW_TO_LOGIN,
    HOME_SCREEN,
    LOGIN_SCREEN,
    COCKTAILS_LIST,
    COCKTAIL_DETAILS,
    USER_ORDERS_LIST
}

sealed class InternalNavigatorData{
    data class CocktailDetailsData(val cocktailId: String) : InternalNavigatorData()
}