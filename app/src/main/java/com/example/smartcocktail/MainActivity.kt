package com.example.smartcocktail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.BaseActivity

class MainActivity : BaseActivity() {
    override fun afterViews() {}

    @Composable
    override fun ContentView() {
        Greeting("HELLO")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.fillMaxSize()
    )
}