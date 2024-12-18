package com.example.smartcocktail.login

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.example.core.base.BaseActivity
import com.example.smartcocktail.login.ui.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    val viewModel: LoginViewModel by viewModels()
    override fun afterViews() {}

    @Composable
    override fun ContentView() {
        LoginScreen(viewModel)
    }
}
