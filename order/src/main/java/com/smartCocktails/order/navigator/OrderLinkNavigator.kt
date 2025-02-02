package com.smartCocktails.order.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.order.coctkatilslist.CocktailsListActivity
import javax.inject.Inject

class OrderLinkNavigator @Inject constructor() : InternalNavigator {
    override fun redirect(activity: BaseActivity, code: BasicInternalCode) {
        when (code) {
            BasicInternalCode.COCKTAILS_LIST ->
                with(activity){
                    startActivity(CocktailsListActivity.prepareIntent(this))
                }

            else -> {}
        }
    }
}