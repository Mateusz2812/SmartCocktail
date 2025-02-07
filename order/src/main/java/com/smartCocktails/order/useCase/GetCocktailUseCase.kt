package com.smartCocktails.order.useCase

import com.smartCocktails.order.service.OrderServiceApi
import com.smartCocktails.order.service.model.CocktailDetails
import com.smartCocktails.order.service.model.CocktailResponse
import javax.inject.Inject

class GetCocktailUseCase @Inject constructor(
    private val orderServiceApi: OrderServiceApi
) {
    suspend fun invoke(id:String): CocktailDetails? {
        val response = orderServiceApi.getCocktail(id)
        return if (response.isSuccessful) {
            response.body()?.drinks?.get(FIRST_INDEX)
        } else {
            null
        }
    }

    companion object{
        private const val FIRST_INDEX = 0
    }
}