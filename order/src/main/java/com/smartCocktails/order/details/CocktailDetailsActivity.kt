package com.smartCocktails.order.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.order.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailDetailsActivity : BaseActivity() {

    @Composable
    override fun ContentView() {
        TODO("Not yet implemented")
    }

    companion object{
        fun prepareIntent(context : Context): Intent{
            return Intent(context, CocktailDetailsActivity::class.java)
        }
    }
}