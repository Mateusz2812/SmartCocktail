package com.smartCocktails.core_api.service

import com.smartCocktails.core_api.model.AllCocktailsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoreApiService {
    @GET("/search.php")
    fun getCocktail(@Query("s") name: String)

    @GET("/filter.php?c=Cocktail")
    fun getAllCocktails(): AllCocktailsResponse
}