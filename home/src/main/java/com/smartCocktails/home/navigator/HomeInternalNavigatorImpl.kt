package com.smartCocktails.home.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.home.HomeActivity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class HomeInternalNavigatorImpl @Inject constructor() : InternalNavigator {
    override fun redirect(activity: BaseActivity, code: BasicInternalCode) {
        when (code) {
            BasicInternalCode.HOME_SCREEN -> {
                val intent = HomeActivity.prepareIntent(activity)
                activity.startActivity(intent)
            }

            else -> Unit
        }
    }
}