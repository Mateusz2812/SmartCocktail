package com.example.smartcocktail.login

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.example.core.base.BaseActivity
import com.example.core.base.BasicInternalCode
import com.example.core.navigator.InternalLinkNavigator
import com.example.smartcocktail.login.ui.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    @Inject
    lateinit var internalNavigator: InternalLinkNavigator

    private val viewModel: LoginViewModel by viewModels()
    override fun afterViews() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect { event ->
                when (event) {
                    is Event.NavigateToHomeActivity -> {
                        internalNavigator.redirectInternalLink(this@LoginActivity, BasicInternalCode.HOME_SCREEN)
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
