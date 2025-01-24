package com.smartCocktails.smartcocktail

import androidx.compose.runtime.Composable
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import com.smartCocktails.smartcocktail.ui.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeActivity : BaseActivity() {
    @Inject
    lateinit var internalNavigator: InternalNavigatorImpl

    override fun afterViews() {}

    @Composable
    override fun ContentView() {
        WelcomeScreen(
            onClick = ::onClick
        )
    }

    private fun onClick() {
        internalNavigator.redirectInternalLink(
            this@WelcomeActivity,
            BasicInternalCode.LOGIN_SCREEN
        )
    }
}
