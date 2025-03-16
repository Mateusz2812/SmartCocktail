package com.smartCocktails.core.navigator

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class AppInternalCodes {
    HOW_TO_LOGIN,
    HOME_SCREEN,
    LOGIN_SCREEN,
    COCKTAILS_LIST,
    COCKTAIL_DETAILS,
    USER_ORDERS_LIST,
    PUSH_DETAILS
}

sealed class InternalNavigatorData{
    data class CocktailDetailsData(val cocktailId: String) : InternalNavigatorData()

    @Parcelize
    data class PushDetailsData(
        val id: String? = null,
        val title: String? = "",
        val subtitle: String? = "",
        val contextText: String? = null,
        val enableOrderListRedirect: Boolean? = false,
        val date: String? = null,
        val graphicId: String? = null
    ):InternalNavigatorData(), Parcelable
}