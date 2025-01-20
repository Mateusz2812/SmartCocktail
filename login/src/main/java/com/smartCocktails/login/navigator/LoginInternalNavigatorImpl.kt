package com.smartCocktails.login.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.login.LoginActivity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class LoginInternalNavigatorImpl @Inject constructor() : InternalNavigator {
    override fun redirect(activity: BaseActivity, code: BasicInternalCode) {
        when (code) {
            BasicInternalCode.LOGIN_SCREEN -> {
                val intent = LoginActivity.prepareIntent(activity)
                activity.startActivity(intent)
            }

            else -> Unit
        }
    }
}