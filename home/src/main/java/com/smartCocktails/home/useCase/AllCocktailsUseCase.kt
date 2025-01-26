package com.smartCocktails.home.useCase

import com.smartCocktails.core_api.model.AllCocktailsResponse
import com.smartCocktails.core_api.service.CoreApiService
import com.smartCocktails.home.service.HomeServiceApi
import javax.inject.Inject

class AllCocktailsUseCase @Inject constructor(
    private val coreApiService: CoreApiService
) {
    suspend fun invoke(): AllCocktailsResponse {
        return coreApiService.getAllCocktails()
    }
}