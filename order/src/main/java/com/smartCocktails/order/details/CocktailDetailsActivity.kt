package com.smartCocktails.order.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.order.R
import com.smartCocktails.order.coctkatilslist.CocktailsListViewModel
import com.smartCocktails.order.coctkatilslist.model.CocktailsListIntent
import com.smartCocktails.order.coctkatilslist.ui.CocktailsListScreen
import com.smartCocktails.order.details.model.CocktailDetailsIntent
import com.smartCocktails.order.details.ui.CocktailDetailsScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CocktailDetailsActivity : BaseActivity() {

    private val viewModel: CocktailDetailsViewModel by viewModels()

    override fun afterViews() {
        setupHandlingEvent()
        viewModel.setEvent(CocktailDetailsIntent.LoadCocktailData)
    }

    @Composable
    override fun ContentView() {
        CocktailDetailsScreen(viewModel)
    }

    private fun setupHandlingEvent() {
        val cocktailId = intent.getStringExtra(COCKTAIL_ID)
        lifecycleScope.launch {
            viewModel.getCocktailDetailsEvent.collect {
                when (it) {
                    CocktailDetailsIntent.FavouriteCocktail -> viewModel.changeFavouriteState(
                        this@CocktailDetailsActivity,
                        cocktailId
                    )

                    CocktailDetailsIntent.LoadCocktailData -> {
                        cocktailId?.let { id ->
                            viewModel.getCocktailDetails(
                                this@CocktailDetailsActivity,
                                id
                            )
                        }
                    }

                    CocktailDetailsIntent.OnBackClick -> onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }

    companion object {
        private const val COCKTAIL_ID = "COCKTAIL_ID"
        fun prepareIntent(context: Context, id: String): Intent {
            return Intent(context, CocktailDetailsActivity::class.java)
                .putExtra(COCKTAIL_ID, id)
        }
    }
}