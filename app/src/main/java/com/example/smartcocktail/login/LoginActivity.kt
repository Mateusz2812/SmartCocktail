package com.example.smartcocktail.login

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.example.core.base.BaseActivity
import com.example.core.base.BasicInternalCode
import com.example.core.navigator.InternalNavigatorImpl
import com.example.smartcocktail.login.ui.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    @Inject
    lateinit var internalNavigator: InternalNavigatorImpl

    private val viewModel: LoginViewModel by viewModels()

    override fun afterViews() {
        setupNavigation()
    }

    private fun setupNavigation() {
        lifecycleScope.launch {
            viewModel.event.collect { event ->
                when (event) {
                    is RedirectEvent.NavigateToHome -> {
                        internalNavigator.redirectInternalLink(
                            this@LoginActivity,
                            BasicInternalCode.HOME_SCREEN
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
}
