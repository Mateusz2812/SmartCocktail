package com.smartCocktails.core.connection.retrofit

import com.smartCocktails.core.build.AppBuildConfig
import com.smartCocktails.core.connection.okhttp.OkHttpClientFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiServiceFactoryImpl @Inject constructor(
    private val okHttpClient: OkHttpClientFactory,
    private val buildConfig: AppBuildConfig
) : ApiServiceFactory {

    override fun <T> createService(serviceClass: Class<T>): T {
        return Retrofit.Builder().apply {
            baseUrl(buildConfig.SERVER_URL())
            addConverterFactory(GsonConverterFactory.create())
            client(okHttpClient.create())
        }.build().create(serviceClass)
    }
}