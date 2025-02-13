package com.smartCocktails.order.utils

import android.content.Context
import com.smartCocktails.core.utils.getSharePreferences
import com.smartCocktails.core.utils.getSharePreferencesEditor

class FavouriteCocktailsUtil {
    companion object {
        fun addOrRemoveCocktailToFavourite(
            context: Context,
            id: String,
            addCocktails: Boolean,
        ) {
            val list = getFavouriteCocktails(context).toMutableList()
            if (addCocktails) {
                list.add(id)
            }else{
                list.remove(id)
            }
            getSharePreferencesEditor(context)
                .putString(FAVOURITE_COCKTAILS, list.joinToString(",")).apply()
        }

        fun getFavouriteCocktails(
            context: Context
        ): List<String> {
            val favouriteCocktails =
                getSharePreferences(context).getString(FAVOURITE_COCKTAILS, "") ?: ""
            return if (favouriteCocktails.isNotEmpty()) {
                favouriteCocktails.split(",")
            } else {
                emptyList()
            }
        }

        fun isFavouriteCocktails(
            context: Context,
            id: String
        ): Boolean {
            val favouriteCocktails = getFavouriteCocktails(context)
            return favouriteCocktails.any { it == id }
        }

        private const val FAVOURITE_COCKTAILS = "FAVOURITE_COCKTAILS"
    }
}