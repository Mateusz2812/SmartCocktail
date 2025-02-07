package com.smartCocktails.core.navigator

import com.smartCocktails.core.base.BaseActivity

interface CodesNavigator {

    val knowInternalCodes: List<AppInternalCodes>

    fun redirect(
        activity: BaseActivity,
        code: AppInternalCodes
    )
}