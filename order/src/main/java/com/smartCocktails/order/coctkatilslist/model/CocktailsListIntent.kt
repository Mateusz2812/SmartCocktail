package com.smartCocktails.order.coctkatilslist.model

sealed class CocktailsListIntent {
    data object LoadData : CocktailsListIntent()
    data class ShowDrink(val id: String) : CocktailsListIntent()
    data class SearchCocktail(val query: String) : CocktailsListIntent()
    data object OpenFilters : CocktailsListIntent()
}

