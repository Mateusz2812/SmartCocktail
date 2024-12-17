package com.example.core.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.core.internal.InternalNavigator
import javax.inject.Inject


abstract class BaseActivity : ComponentActivity() {

    @Inject
    lateinit var internalNavigator: InternalNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContentView()
        }
        afterViews()
    }

    open fun afterViews() = Unit

    @Composable
    abstract fun ContentView()
}