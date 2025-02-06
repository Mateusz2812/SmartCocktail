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
import com.smartCocktails.home.model.HomeIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val internalNavigator: InternalNavigatorImpl
) : ViewModel() {

    private val homeScreenEvent = MutableSharedFlow<HomeIntent>()
    val getHomeScreenEvent = homeScreenEvent

    fun setEvent(homeIntent: HomeIntent) {
        viewModelScope.launch {
            homeScreenEvent.emit( homeIntent)
        }
    }

    fun logout(context: Context) {
        val dialog = AlertDialog.Builder(context)
            .setTitle(getString(context, R.string.exit_popup_title))
            .setMessage(getString(context, R.string.exit_popup_description))
            .setPositiveButton(getString(context, R.string.exit_popup_positive_button)) { _, _ ->
                internalNavigator.redirectInternalLink(
                    context as BaseActivity,
                    BasicInternalCode.LOGIN_SCREEN
                )
            }
            .setNegativeButton(
                getString(
                    context,
                    R.string.exit_popup_negative_button
                )
            ) { dialog, _ ->
                dialog.dismiss()
            }.create()
        dialog.show()
    }

    fun openCocktailsList(context: Context) {
        internalNavigator.redirectInternalLink(
            context as BaseActivity,
            BasicInternalCode.COCKTAILS_LIST
        )

    }
}