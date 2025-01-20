package com.smartCocktails.core.connection.retrofit

import com.smartCocktails.core.build.AppBuildConfig
import com.smartCocktails.core.connection.okhttp.AppOkHttpClient
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@Singleton
class AppRetrofitImpl @Inject constructor(
    private val okHttpClient: AppOkHttpClient,
    private val buildConfig: AppBuildConfig
) : AppServiceApi {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl(buildConfig.SERVER_URL())
            addConverterFactory(GsonConverterFactory.create())
            client(okHttpClient.create())
        }.build()
    }

    override fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}