package com.smartCocktails.order.service

import com.smartCocktails.order.service.model.AllCocktailsResponse
import com.smartCocktails.order.service.model.CocktailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OrderServiceApi {
    @GET("lookup.php")
    suspend fun getCocktail(@Query("i") id: String): Response<CocktailResponse>

    @GET("filter.php?c=Cocktail")
    suspend fun getAllCocktails(): Response<AllCocktailsResponse>
}