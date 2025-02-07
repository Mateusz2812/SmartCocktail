package com.smartCocktails.order.details.model

import com.smartCocktails.order.coctkatilslist.model.CocktailsListIntent

sealed class CocktailDetailsIntent {
    data object LoadCocktailData : CocktailDetailsIntent()
}