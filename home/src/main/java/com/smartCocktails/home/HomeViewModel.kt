package com.smartCocktails.home

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.getString
import androidx.lifecycle.ViewModel
import com.example.home.R
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.base.BasicInternalCode
import com.smartCocktails.core.navigator.InternalNavigatorImpl
import com.smartCocktails.home.model.HomeIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val internalNavigator: InternalNavigatorImpl
): ViewModel(){

    fun handleEvent(event: HomeIntent){
        when(event){
            HomeIntent.GoToOrderCocktail -> {}
            HomeIntent.ShowCocktails -> {}
            HomeIntent.GoToConfigureCocktail -> {}
            is HomeIntent.LogOut -> logout(event.context)
        }
    }

/*    private fun loadAllCocktails(){
        viewModelScope.launch {
            val cocktails = allCocktailsUseCase.invoke().drinks
            cocktailsDataState.update { cocktails }
        }
    }*/

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