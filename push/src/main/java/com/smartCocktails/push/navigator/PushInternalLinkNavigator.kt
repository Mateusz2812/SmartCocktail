package com.smartCocktails.push.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.CodesNavigator
import com.smartCocktails.core.navigator.InternalNavigatorData
import com.smartCocktails.push.details.PushDetailsActivity
import javax.inject.Inject

class PushInternalLinkNavigator @Inject constructor() : CodesNavigator {

    override val knowInternalCodes: List<AppInternalCodes>
        get() = listOf(
            AppInternalCodes.INBOX_NOTIFICATIONS_LIST
        )

    override fun redirect(
        activity: BaseActivity,
        code: AppInternalCodes,
        navigatorData: InternalNavigatorData?
    ) {
        if (code == AppInternalCodes.INBOX_NOTIFICATIONS_LIST) {

        }
    }
}