package com.smartCocktails.order.coctkatilslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartCocktails.core.base.BaseActivity
import com.smartCocktails.core.navigator.AppInternalCodes
import com.smartCocktails.core.navigator.InternalNavigator
import com.smartCocktails.core.navigator.InternalNavigatorData
import com.smartCocktails.order.coctkatilslist.model.CocktailsListIntent
import com.smartCocktails.order.coctkatilslist.model.CocktailsListState
import com.smartCocktails.order.useCase.AllCocktailsUseCase
import com.smartCocktails.order.useCase.GetCocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailsListViewModel @Inject constructor(
    private val allCocktailsUseCase: AllCocktailsUseCase,
    private val internalNavigator: InternalNavigator
) : ViewModel() {

    private val cocktailsListEvent = MutableStateFlow<CocktailsListIntent?>(null)
    val getCocktailsListEvent = cocktailsListEvent

    private val cocktailsListState = MutableStateFlow(CocktailsListState())
    val getCocktailsListState = cocktailsListState

    fun setEvent(event: CocktailsListIntent) {
        cocktailsListEvent.update { event }
    }

    fun getAllCocktails() {
        cocktailsListState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val response = allCocktailsUseCase.invoke()
            cocktailsListState.update {
                it.copy(
                    isLoading = false,
                    cocktailsList = response?.drinks.orEmpty()
                )
            }
        }
    }

    fun showCocktailDetails(activity: BaseActivity, id: String) {
        internalNavigator.redirectInternalLink(
            activity = activity,
            code = AppInternalCodes.COCKTAIL_DETAILS,
            navigatorData = InternalNavigatorData.CocktailDetailsData(id)
        )
    }
}