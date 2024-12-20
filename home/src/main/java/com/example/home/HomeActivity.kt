package com.example.home

import androidx.compose.runtime.Composable
import com.example.core.base.BaseActivity
import com.example.home.ui.HomeScreen

class HomeActivity : BaseActivity() {
    @Composable
    override fun ContentView() {
        HomeScreen()
    }
}