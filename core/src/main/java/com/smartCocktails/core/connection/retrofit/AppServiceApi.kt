package com.smartCocktails.core.connection.retrofit

import retrofit2.Retrofit

interface AppServiceApi {
    fun <T> createService(serviceClass: Class<T>): T
}