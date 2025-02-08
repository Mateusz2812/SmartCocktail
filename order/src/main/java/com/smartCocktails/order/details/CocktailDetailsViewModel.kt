package com.smartCocktails.order.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartCocktails.order.details.model.CocktailDetailsIntent
import com.smartCocktails.order.details.model.CocktailDetailsState
import com.smartCocktails.order.useCase.GetCocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailDetailsViewModel @Inject constructor(
    private val getCocktailUseCase: GetCocktailUseCase,
): ViewModel() {

    private val cocktailDetailsEvent = MutableStateFlow<CocktailDetailsIntent?>(null)
    val getCocktailDetailsEvent= cocktailDetailsEvent

    private val cocktailDetailsState = MutableStateFlow(CocktailDetailsState())
    val getCocktailDetailsState = cocktailDetailsState

    fun setEvent(event: CocktailDetailsIntent) {
        cocktailDetailsEvent.update { event }
    }

    fun changeFavouriteState(){
        cocktailDetailsState.update { it.copy(isFavourite = !it.isFavourite) }
    }

    fun getCocktailDetails(id: String) {
        cocktailDetailsState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val response = getCocktailUseCase.invoke(id)
            cocktailDetailsState.update {
                it.copy(
                    isLoading = false,
                    details = response?.transformToCocktailItemData()
                )
            }
        }
    }
}