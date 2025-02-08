package com.smartCocktails.order.details.model

import com.smartCocktails.order.model.CocktailItemDetailsData

data class CocktailDetailsState(
    val isLoading: Boolean = false,
    val isFavourite: Boolean = false,
    val details: CocktailItemDetailsData? = null
)