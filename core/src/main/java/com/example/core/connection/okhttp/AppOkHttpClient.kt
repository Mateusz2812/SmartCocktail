package com.example.core.connection.okhttp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AppOkHttpClient @Inject constructor() {

    fun create(): OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptors()
        addTimeouts()
    }.build()

    private fun OkHttpClient.Builder.addInterceptors() {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        addInterceptor(loggingInterceptor)
    }

    private fun OkHttpClient.Builder.addTimeouts(){
        connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
    }

    companion object{
        private const val CONNECT_TIMEOUT = 20L
        private const val READ_TIMEOUT = 30L
        private const val WRITE_TIMEOUT = 30L

    }

}