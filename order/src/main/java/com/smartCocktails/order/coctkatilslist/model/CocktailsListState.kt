package com.smartCocktails.order.coctkatilslist.model

import com.smartCocktails.order.service.model.Drink

data class CocktailsListState(
    val isLoading: Boolean = false,
    val cocktailsList: List<Drink> = emptyList(),
    val error: Boolean = false
)