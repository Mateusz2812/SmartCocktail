package com.smartCocktails.order.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.CodesNavigator
import com.smartCocktails.order.coctkatilslist.CocktailsListActivity
import javax.inject.Inject

class OrderLinkCodesNavigator @Inject constructor() : CodesNavigator {

    override val knowInternalCodes: List<AppInternalCodes> =
        listOf(AppInternalCodes.COCKTAILS_LIST , AppInternalCodes.COCKTAIL_DETAILS)

    override fun redirect(activity: BaseActivity, code: AppInternalCodes) {
        when (code) {
            AppInternalCodes.COCKTAILS_LIST ->
                with(activity){
                    startActivity(CocktailsListActivity.prepareIntent(this))
                }

            else -> {}
        }
    }
}