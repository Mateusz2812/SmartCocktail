package com.smartCocktails.order.useCase

import com.smartCocktails.core_api.model.AllCocktailsResponse
import com.smartCocktails.order.service.OrderServiceApi
import javax.inject.Inject

class AllCocktailsUseCase @Inject constructor(
    private val orderServiceApi: OrderServiceApi
) {
    suspend fun invoke(): AllCocktailsResponse? {
        val response = orderServiceApi.getAllCocktails()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}