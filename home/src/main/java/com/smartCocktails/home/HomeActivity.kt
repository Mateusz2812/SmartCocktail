package com.smartCocktails.home

import android.content.Context
import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.home.R
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import com.smartCocktails.home.model.HomeIntent
import com.smartCocktails.home.ui.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.update
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
                viewModel.sendIntent(HomeIntent.LogOut(this@HomeActivity))
            }
        })
    }

    companion object {
        fun prepareIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}