package com.smartCocktails.core.connection.retrofit

interface ApiServiceFactory {
    fun <T> createService(serviceClass: Class<T>): T
}