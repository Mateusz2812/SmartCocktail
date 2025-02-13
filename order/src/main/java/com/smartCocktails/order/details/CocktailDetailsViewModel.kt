package com.smartCocktails.order.details

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartCocktails.order.details.model.CocktailDetailsIntent
import com.smartCocktails.order.details.model.CocktailDetailsState
import com.smartCocktails.order.useCase.GetCocktailUseCase
import com.smartCocktails.order.utils.FavouriteCocktailsUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailDetailsViewModel @Inject constructor(
    private val getCocktailUseCase: GetCocktailUseCase,
) : ViewModel() {

    private val cocktailDetailsEvent = MutableSharedFlow<CocktailDetailsIntent>()
    val getCocktailDetailsEvent = cocktailDetailsEvent

    private val cocktailDetailsState = MutableStateFlow(CocktailDetailsState())
    val getCocktailDetailsState = cocktailDetailsState

    fun setEvent(event: CocktailDetailsIntent) {
        viewModelScope.launch { cocktailDetailsEvent.emit(event) }
    }

    fun changeFavouriteState(context: Context, id: String?) {
        id?.let {
            cocktailDetailsState.update { it.copy(isFavourite = !it.isFavourite) }
            FavouriteCocktailsUtil.addOrRemoveCocktailToFavourite(
                context,
                id,
                cocktailDetailsState.value.isFavourite
            )
        }
    }

    fun getCocktailDetails(context: Context, id: String) {
        cocktailDetailsState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val response = getCocktailUseCase.invoke(id)
            cocktailDetailsState.update {
                it.copy(
                    isLoading = false,
                    isFavourite = FavouriteCocktailsUtil.isFavouriteCocktails(context, id),
                    details = response?.transformToCocktailItemData()
                )
            }
        }
    }
}