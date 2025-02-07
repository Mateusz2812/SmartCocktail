package com.smartCocktails.login

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.login.ui.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    @Inject
    lateinit var internalNavigator: InternalNavigator

    private val viewModel: LoginViewModel by viewModels()

    override fun afterViews() {
        setupNavigation()
    }

    private fun setupNavigation() {
        lifecycleScope.launch {
            viewModel.event.collect { event ->
                when (event) {
                    is LoginRedirectEvent.NavigateToHome -> {
                        internalNavigator.redirectInternalLink(
                            this@LoginActivity,
                            AppInternalCodes.HOME_SCREEN
                        )
                    }

                    else -> {}
                }
            }
        }
    }

    @Composable
    override fun ContentView() {
        LoginScreen(viewModel)
    }

    companion object {
        fun prepareIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
