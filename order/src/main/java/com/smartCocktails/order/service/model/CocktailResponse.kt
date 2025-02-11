package com.smartCocktails.order.service.model

import com.google.gson.annotations.SerializedName
import com.smartCocktails.order.model.CocktailItemDetailsData

data class CocktailResponse(
    @SerializedName("drinks")
    val drinks: List<CocktailDetails>
)

data class CocktailDetails(
    @SerializedName("idDrink")
    val idDrink: String,
    @SerializedName("strDrink")
    val strDrink: String,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strAlcoholic")
    val strAlcoholic: String?,
    @SerializedName("strGlass")
    val strGlass: String?,
    @SerializedName("strInstructions")
    val strInstructions: String?,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?,
    @SerializedName("strIngredient1")
    val strIngredient1: String?,
    @SerializedName("strIngredient2")
    val strIngredient2: String?,
    @SerializedName("strIngredient3")
    val strIngredient3: String?,
    @SerializedName("strIngredient4")
    val strIngredient4: String?,
    @SerializedName("strIngredient5")
    val strIngredient5: String?,
    @SerializedName("strIngredient6")
    val strIngredient6: String?,
    @SerializedName("strIngredient7")
    val strIngredient7: String?,
    @SerializedName("strIngredient8")
    val strIngredient8: String?,
    @SerializedName("strIngredient9")
    val strIngredient9: String?,
    @SerializedName("strIngredient10")
    val strIngredient10: String?,
    @SerializedName("strMeasure1")
    val strMeasure1: String?,
    @SerializedName("strMeasure2")
    val strMeasure2: String?,
    @SerializedName("strMeasure3")
    val strMeasure3: String?,
    @SerializedName("strMeasure4")
    val strMeasure4: String?,
    @SerializedName("strMeasure5")
    val strMeasure5: String?,
    @SerializedName("strMeasure6")
    val strMeasure6: String?,
    @SerializedName("strMeasure7")
    val strMeasure7: String?,
    @SerializedName("strMeasure8")
    val strMeasure8: String?,
    @SerializedName("strMeasure9")
    val strMeasure9: String?,
    @SerializedName("strMeasure10")
    val strMeasure10: String?,
) {

    fun transformToCocktailItemData() = CocktailItemDetailsData(
        name = strDrink,
        image = strDrinkThumb,
        id = idDrink,
        category = strCategory,
        glass = strGlass,
        alcoholic = strAlcoholic,
        ingredients = getIngredients(),
        ingredientsWithMeasure = getIngredientsWithMeasure()
    )

    private fun getIngredientsWithMeasure(): List<Pair<String?, String?>> {
        return listOfNotNull(
            strIngredient1 to strMeasure1,
            strIngredient2 to strMeasure2,
            strIngredient3 to strMeasure3,
            strIngredient4 to strMeasure4,
            strIngredient5 to strMeasure5,
            strIngredient6 to strMeasure6,
            strIngredient7 to strMeasure7,
            strIngredient8 to strMeasure8,
            strIngredient9 to strMeasure9,
            strIngredient10 to strMeasure10
        )
    }

    private fun getIngredients(): List<String?> {
        return listOfNotNull(
            strIngredient1,
            strIngredient2,
            strIngredient3,
            strIngredient4,
            strIngredient5,
            strIngredient6,
            strIngredient7,
            strIngredient8,
            strIngredient9,
            strIngredient10
        )
    }
}