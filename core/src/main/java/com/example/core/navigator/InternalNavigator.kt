package com.example.core.navigator

import com.example.core.base.BaseActivity
import com.example.core.base.BasicInternalCode

interface InternalNavigator {

    fun redirect(
        activity: BaseActivity,
        code: BasicInternalCode
    )
}