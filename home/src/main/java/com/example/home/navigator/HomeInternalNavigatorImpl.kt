package com.example.home.navigator

import android.content.Intent
import com.example.core.base.BaseActivity
import com.example.core.base.BasicInternalCode
import com.example.core.navigator.InternalNavigator
import com.example.home.HomeActivity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class HomeInternalNavigatorImpl @Inject constructor() : InternalNavigator {
    override fun redirect(activity: BaseActivity, code: BasicInternalCode) {
        when (code) {
            BasicInternalCode.HOME_SCREEN -> {
                val intent = Intent(activity, HomeActivity::class.java)
                activity.startActivity(intent)
            }

            else -> Unit
        }
    }
}