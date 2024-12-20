package com.example.core.navigator

import com.example.core.base.BaseActivity
import com.example.core.base.BasicInternalCode
import javax.inject.Inject

class InternalNavigatorImpl @Inject constructor(): InternalNavigator {

    override fun redirect(activity: BaseActivity, code: BasicInternalCode) {}
}