package com.smartCocktails.home.model

import com.smartCocktails.core_api.model.Drink

data class HomeState(
    val isLoading: Boolean = false,
    val data: List<Drink> = emptyList(),
    val error: Boolean = false
)
