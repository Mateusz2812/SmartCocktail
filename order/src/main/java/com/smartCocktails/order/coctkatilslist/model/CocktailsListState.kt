package com.smartCocktails.order.coctkatilslist.model

import com.smartCocktails.core_api.model.Drink

data class CocktailsListState(
    val isLoading: Boolean = false,
    val cocktailsList: List<Drink> = emptyList(),
    val error: Boolean = false
)