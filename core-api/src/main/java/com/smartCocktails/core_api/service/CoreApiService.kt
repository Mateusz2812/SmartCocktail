package com.smartCocktails.core_api.service


import retrofit2.http.GET
import retrofit2.http.Query

interface CoreApiService {
    @GET("/search.php")
    fun getCocktail(@Query("s") name: String)
}