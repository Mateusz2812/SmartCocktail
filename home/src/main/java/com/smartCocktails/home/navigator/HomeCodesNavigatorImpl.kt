package com.smartCocktails.home.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.CodesNavigator
import com.smartCocktails.core.navigator.InternalNavigatorData
import com.smartCocktails.home.HomeActivity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class HomeCodesNavigatorImpl @Inject constructor() : CodesNavigator {
    override val knowInternalCodes: List<AppInternalCodes> =
        listOf(AppInternalCodes.HOME_SCREEN)

    override fun redirect(
        activity: BaseActivity,
        code: AppInternalCodes,
        navigatorData: InternalNavigatorData?
    ) {
        when (code) {
            AppInternalCodes.HOME_SCREEN -> {
                val intent = HomeActivity.prepareIntent(activity)
                activity.startActivity(intent)
            }

            else -> Unit
        }
    }
}