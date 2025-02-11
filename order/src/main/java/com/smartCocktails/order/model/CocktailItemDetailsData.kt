package com.smartCocktails.order.model

data class CocktailItemDetailsData(
    val name: String,
    val image: String? = null,
    val id: String,
    val category: String? = null,
    val alcoholic: String? = null,
    val glass: String? = null,
    val ingredients: List<String?> = emptyList(),
    val ingredientsWithMeasure: List<Pair<String?,String?>> = emptyList()
)