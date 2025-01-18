package com.smartCocktails.core.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode

interface InternalNavigator {

    fun redirect(
        activity: BaseActivity,
        code: BasicInternalCode
    )
}