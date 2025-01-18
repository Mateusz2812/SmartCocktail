package com.smartCocktails.core.navigator

import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import javax.inject.Inject

class CoreInternalNavigator @Inject constructor(): InternalNavigator {

    override fun redirect(activity: BaseActivity, code: BasicInternalCode) {}
}