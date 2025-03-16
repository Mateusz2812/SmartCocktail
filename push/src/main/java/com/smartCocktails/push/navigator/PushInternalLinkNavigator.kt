package com.smartCocktails.push.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.CodesNavigator
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.core.navigator.InternalNavigatorData
import com.smartCocktails.push.details.PushDetailsActivity
import javax.inject.Inject

class PushInternalLinkNavigator @Inject constructor() : CodesNavigator {

    override val knowInternalCodes: List<AppInternalCodes>
        get() = listOf(
            AppInternalCodes.PUSH_DETAILS
        )

    override fun redirect(
        activity: BaseActivity,
        code: AppInternalCodes,
        navigatorData: InternalNavigatorData?
    ) {
        if (code == AppInternalCodes.PUSH_DETAILS) {
            with(activity) {
                startActivity(
                    PushDetailsActivity.prepareIntent(
                        context = this,
                        pushDetailsData = navigatorData as InternalNavigatorData.PushDetailsData
                    )
                )
            }
        }
    }
}