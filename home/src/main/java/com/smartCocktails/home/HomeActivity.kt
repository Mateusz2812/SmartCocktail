package com.smartCocktails.home

import android.content.Context
import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import com.smartCocktails.home.model.HomeIntent
import com.smartCocktails.home.ui.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    @Inject
    lateinit var internalNavigator: InternalNavigatorImpl


    private val viewModel: HomeViewModel by viewModels()


    override fun afterViews() {
        applyBackPressed()
    }

    @Composable
    override fun ContentView() {
        HomeScreen(viewModel)
    }

    private fun applyBackPressed() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.handleEvent(HomeIntent.LogOut(this@HomeActivity))
            }
        })
    }

    companion object {
        fun prepareIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}