package com.smartCocktails.order.service.model

import com.google.gson.annotations.SerializedName
import com.smartCocktails.order.model.CocktailListItemData

data class AllCocktailsResponse(
    @SerializedName("drinks")
    val drinks: List<Drink>
)

data class Drink(
    @SerializedName("strDrink")
    val strDrink: String,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String,
    @SerializedName("idDrink")
    val idDrink: String,
){
    fun transformToCocktailItemData() = CocktailListItemData(
        name = strDrink,
        image = strDrinkThumb,
        id = idDrink
    )
}