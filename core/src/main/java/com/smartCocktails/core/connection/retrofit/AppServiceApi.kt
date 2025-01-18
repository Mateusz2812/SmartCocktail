package com.smartCocktails.core.connection.retrofit

import retrofit2.Retrofit

interface AppServiceApi {
    fun createService(): Retrofit
}