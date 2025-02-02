package com.smartCocktails.core_api.model

import com.google.gson.annotations.SerializedName

data class AllCocktailsResponse(
    @SerializedName("drinks")
    val drinks: List<Drink>
)

data class Drink(
    @SerializedName("strDrink")
    val name: String,
    @SerializedName("strDrinkThumb")
    val image: String,
    @SerializedName("idDrink")
    val id: String,
)