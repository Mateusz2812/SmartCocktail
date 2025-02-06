package com.smartCocktails.order.useCase

import com.smartCocktails.order.service.OrderServiceApi
import com.smartCocktails.order.service.model.CocktailResponse
import com.smartCocktails.order.service.model.DrinkDetails
import javax.inject.Inject

class GetCocktailUseCase @Inject constructor(
    private val orderServiceApi: OrderServiceApi
) {
    suspend fun invoke(id:String): CocktailResponse? {
        val response = orderServiceApi.getCocktail(id)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}