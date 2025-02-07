package com.smartCocktails.core.navigator

import com.smartCocktails.core.base.BaseActivity
import javax.inject.Inject

class InternalNavigator @Inject constructor(
    private val codesNavigators: Set<CodesNavigator>
) {
    private val codes = buildList {
        codesNavigators.forEach {
            addAll(it.knowInternalCodes)
        }
    }

    fun redirectInternalLink(activity: BaseActivity, code: AppInternalCodes) {
        if (!codes.contains(code)){
            return
        }
        codesNavigators.forEach {
            it.redirect(activity, code)
        }
    }
}