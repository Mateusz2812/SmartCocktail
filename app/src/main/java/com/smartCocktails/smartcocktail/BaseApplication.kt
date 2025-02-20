package com.smartCocktails.smartcocktail

import android.app.Application
import com.smartCocktails.push.PushServiceManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication: Application() {
    @Inject
    lateinit var pushServiceManager: PushServiceManager

    override fun onCreate() {
        super.onCreate()
        pushServiceManager.createNotificationChannel(this)
    }
}