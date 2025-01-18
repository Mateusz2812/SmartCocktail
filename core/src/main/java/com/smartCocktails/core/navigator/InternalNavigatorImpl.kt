package com.smartCocktails.core.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import javax.inject.Inject

class InternalNavigatorImpl @Inject constructor(
    private val internalNavigators: Set<InternalNavigator>
) {
    fun redirectInternalLink(activity: BaseActivity, code: BasicInternalCode) {
        internalNavigators.forEach {
            it.redirect(activity, code)
        }
    }
}