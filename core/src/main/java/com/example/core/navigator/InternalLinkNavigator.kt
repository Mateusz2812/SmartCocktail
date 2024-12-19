package com.example.core.navigator

import com.example.core.base.BaseActivity
import com.example.core.base.BasicInternalCode
import javax.inject.Inject

class InternalLinkNavigator @Inject constructor(
    private val internalNavigators: Set<InternalNavigator>
) {
    fun redirectInternalLink(activity: BaseActivity, code: BasicInternalCode) {
        internalNavigators.forEach {
            it.redirect(activity, code)
        }
    }
}