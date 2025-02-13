package com.smartCocktails.core.utils

import android.content.Context
import android.content.SharedPreferences
import com.smartCocktails.cores.BuildConfig


fun getSharePreferences(context: Context): SharedPreferences {
    val sharedPreferences =
        context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, Context.MODE_PRIVATE)
    return sharedPreferences
}

fun getSharePreferencesEditor(context: Context): SharedPreferences.Editor {
    return getSharePreferences(context).edit()
}

fun saveSharePreferencesAfterEdit(context: Context) {
    getSharePreferencesEditor(context).apply()
}