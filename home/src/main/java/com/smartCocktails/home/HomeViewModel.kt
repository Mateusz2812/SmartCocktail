package com.smartCocktails.home

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.getString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.R
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import com.smartCocktails.core_api.model.Drink
import com.smartCocktails.home.model.HomeIntent
import com.smartCocktails.home.useCase.AllCocktailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val internalNavigator: InternalNavigatorImpl,
    private val allCocktailsUseCase: AllCocktailsUseCase
): ViewModel(){

    private val cocktailsDataState: MutableStateFlow<List<Drink>> = MutableStateFlow(emptyList())
    val dataState = cocktailsDataState

    fun handleEvent(event: HomeIntent){
        when(event){
            HomeIntent.LoadAllCocktails -> loadAllCocktails()
            is HomeIntent.ShowCocktail -> TODO()
            is HomeIntent.LogOut -> logout(event.context)
        }
    }

    private fun loadAllCocktails(){
        viewModelScope.launch {
            val cocktails = allCocktailsUseCase.invoke().drinks
            cocktailsDataState.update { cocktails }
        }
    }

    private fun logout(context: Context) {
        val dialog = AlertDialog.Builder(context)
            .setTitle(getString(context,R.string.exit_popup_title))
            .setMessage(getString(context, R.string.exit_popup_description))
            .setPositiveButton(getString(context, R.string.exit_popup_positive_button)) { _, _ ->
                internalNavigator.redirectInternalLink(context as BaseActivity, BasicInternalCode.LOGIN_SCREEN)
            }
            .setNegativeButton(getString(context, R.string.exit_popup_negative_button)) { dialog, _ ->
                dialog.dismiss()
            }.create()
        dialog.show()
    }
}