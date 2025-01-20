package com.smartCocktails.smartcocktail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeActivity : BaseActivity() {
    @Inject
    lateinit var internalNavigator: InternalNavigatorImpl

    override fun afterViews() {}

    @Composable
    override fun ContentView() {
        Card(modifier = Modifier.fillMaxSize()) {
            Button(modifier = Modifier.padding(top=20.dp), onClick = ::onClick) { }
        }
    }

    private fun onClick(){
        internalNavigator.redirectInternalLink(
            this@WelcomeActivity,
            BasicInternalCode.LOGIN_SCREEN
        )
    }
}
