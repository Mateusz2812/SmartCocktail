package com.smartCocktails.order.service

import com.smartCocktails.order.service.model.AllCocktailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OrderServiceApi {
    @GET("search.php")
    fun getCocktail(@Query("s") name: String)

    @GET("filter.php?c=Cocktail")
    suspend fun getAllCocktails(): Response<AllCocktailsResponse>
}