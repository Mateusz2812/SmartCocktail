package com.smartCocktails.order.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.CodesNavigator
import com.smartCocktails.core.navigator.InternalNavigatorData
import com.smartCocktails.order.coctkatilslist.CocktailsListActivity
import com.smartCocktails.order.details.CocktailDetailsActivity
import javax.inject.Inject

class OrderLinkCodesNavigator @Inject constructor() : CodesNavigator {

    override val knowInternalCodes: List<AppInternalCodes> =
        listOf(AppInternalCodes.COCKTAILS_LIST, AppInternalCodes.COCKTAIL_DETAILS)

    override fun redirect(
        activity: BaseActivity,
        code: AppInternalCodes,
        navigatorData: InternalNavigatorData?
    ) {
        with(activity) {
            when (code) {
                AppInternalCodes.COCKTAILS_LIST ->
                    startActivity(CocktailsListActivity.prepareIntent(this))

                AppInternalCodes.COCKTAIL_DETAILS -> {
                    val data = navigatorData as InternalNavigatorData.CocktailDetailsData
                    startActivity(CocktailDetailsActivity.prepareIntent(this))

                }
                else -> {}
            }
        }
    }
}