package com.smartCocktails.order.coctkatilslist

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.order.coctkatilslist.model.CocktailsListIntent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CocktailsListActivity : BaseActivity() {
    private val viewModel: CocktailsListViewModel by viewModels()

    override fun afterViews() {
        setupHandlingEvent()
        viewModel.setEvent(CocktailsListIntent.LoadData)
    }

    @Composable
    override fun ContentView() {
        Card {  }
    }

    private fun setupHandlingEvent(){
        lifecycleScope.launch {
            viewModel.getCocktailsListEvent.collect {
                when (it) {
                    CocktailsListIntent.LoadData -> viewModel.getAllCocktails()
                    CocktailsListIntent.OpenFilters -> TODO()
                    is CocktailsListIntent.SearchCocktail -> TODO()
                    is CocktailsListIntent.ShowDrink -> TODO()
                    else -> {}
                }
            }
        }
    }

    companion object{
        fun prepareIntent(context: Context): Intent{
            return Intent(context, CocktailsListActivity::class.java)
        }
    }
}