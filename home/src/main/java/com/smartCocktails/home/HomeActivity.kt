package com.smartCocktails.home

import android.content.Context
import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import com.smartCocktails.home.model.HomeIntent
import com.smartCocktails.home.ui.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    @Inject
    lateinit var internalNavigator: InternalNavigatorImpl


    private val viewModel: HomeViewModel by viewModels()


    override fun afterViews() {
        applyBackPressed()
        handleEvent()
    }

    private fun handleEvent() {
        lifecycleScope.launch {
            viewModel.getHomeScreenEvent.collect {
                when (it) {
                    HomeIntent.GoToOrderCocktail -> {
                        viewModel.openCocktailsList(this@HomeActivity)
                    }

                    HomeIntent.ShowCocktails -> {}
                    HomeIntent.GoToConfigureCocktail -> {}
                    is HomeIntent.LogOut -> viewModel.logout(this@HomeActivity)
                }
            }
        }
    }

    @Composable
    override fun ContentView() {
        HomeScreen(viewModel)
    }

    private fun applyBackPressed() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.setEvent(HomeIntent.LogOut(this@HomeActivity))
            }
        })
    }

    companion object {
        fun prepareIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}