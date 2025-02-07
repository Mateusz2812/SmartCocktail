package com.smartCocktails.core.navigator

import android.widget.Toast
import androidx.compose.ui.res.stringResource
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.cores.R
import javax.inject.Inject

class InternalNavigator @Inject constructor(
    private val codesNavigators: Set<CodesNavigator>
) {
    private val codes = buildList {
        codesNavigators.forEach {
            addAll(it.knowInternalCodes)
        }
    }

    fun redirectInternalLink(
        activity: BaseActivity,
        code: AppInternalCodes,
        navigatorData: InternalNavigatorData? = null
    ) {
        if (!codes.contains(code)) {
            Toast.makeText(
                activity,
                activity.getString(R.string.no_access_toast),
                Toast.LENGTH_LONG
            ).show()
            return
        }
        codesNavigators.forEach {
            it.redirect(activity, code, navigatorData)
        }
    }
}