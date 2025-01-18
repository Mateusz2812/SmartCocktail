package com.smartCocktails.core.connection.retrofit

import com.smartCocktails.core.build.AppBuildConfig
import com.smartCocktails.core.connection.okhttp.AppOkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class AppRetrofitServiceImpl @Inject constructor(
    private val okHttpClient: AppOkHttpClient,
    private val buildConfig: AppBuildConfig
) : AppServiceApi {
    override fun createService(): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(buildConfig.SERVER_URL())
            addConverterFactory(GsonConverterFactory.create())
            client(okHttpClient.create())
        }.build()
    }


}