package com.smartCocktails.login.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.CodesNavigator
import com.smartCocktails.login.LoginActivity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class LoginCodesNavigatorImpl @Inject constructor() : CodesNavigator {

    override val knowInternalCodes: List<AppInternalCodes> =
        listOf(AppInternalCodes.LOGIN_SCREEN)

    override fun redirect(activity: BaseActivity, code: AppInternalCodes) {
        when (code) {
            AppInternalCodes.LOGIN_SCREEN -> {
                val intent = LoginActivity.prepareIntent(activity)
                activity.startActivity(intent)
            }

            else -> Unit
        }
    }
}