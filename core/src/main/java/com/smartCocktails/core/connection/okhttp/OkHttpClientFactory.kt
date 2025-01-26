package com.smartCocktails.core.connection.okhttp

import okhttp3.OkHttpClient

interface OkHttpClientFactory {
    fun create(): OkHttpClient
}